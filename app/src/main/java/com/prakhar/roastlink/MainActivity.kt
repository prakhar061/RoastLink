package com.prakhar.roastlink

import android.content.ClipboardManager
import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.coroutines.launch

// 🎨 Theme Colors (Matches Urban Roast Lounge Layout)
val GlassBackground = Color(0xFF262626).copy(alpha = 0.65f) // Frosted glass opacity
val GlassBorder = Color.White.copy(alpha = 0.12f)
val CyanTextGlow = Color(0xFF4DD0E1) // 🩵 Premium Neon Cyan Color

// ❤️ Gradation Red Definition (Dark Deep Red to Vibrant Hot Orange-Red)
val GradientRedStart = Color(0xFFB71C1C)
val GradientRedEnd = Color(0xFFFF3D00)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // 🧱 Root Box: Spot-light dark background set across the entire layout
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.roast_bg), // Spotlight texture wall
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                UrbanRoastLoungeScreen()
            }
        }
    }
}

// 🗺️ Core QR Generator Engine
fun generateQRCode(text: String): Bitmap? {
    return try {
        val writer = QRCodeWriter()
        val bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, 512, 512)
        val width = bitMatrix.width
        val height = bitMatrix.height
        val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        for (x in 0 until width) {
            for (y in 0 until height) {
                bmp.setPixel(x, y, if (bitMatrix.get(x, y)) android.graphics.Color.BLACK else android.graphics.Color.WHITE)
            }
        }
        bmp
    } catch (e: Exception) {
        null
    }
}

@Composable
fun UrbanRoastLoungeScreen() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var inputUrl by remember { mutableStateOf("") }
    var roastedUrl by remember { mutableStateOf("") }
    var isProcessing by remember { mutableStateOf(false) }
    var qrBitmap by remember { mutableStateOf<Bitmap?>(null) }

    // 🔥 Premium Hot Red Gradient Brush
    val fieryRedGradient = Brush.horizontalGradient(listOf(GradientRedStart, GradientRedEnd))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 🚀 Added Extra Padding to bring the Logo gently down
        Spacer(modifier = Modifier.height(35.dp))

        // 🦝 1. RACCOON LOGO (With edge-cutting circular clipping bounds)
        Image(
            painter = painterResource(id = R.drawable.roast_logo),
            contentDescription = "RoastLink Logo",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(15.dp))

        // 💳 2. CORE INPUT CONTAINER (Frosted Glass Aesthetics)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(GlassBackground, RoundedCornerShape(24.dp))
                .border(1.5.dp, GlassBorder, RoundedCornerShape(24.dp))
                .padding(20.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                // 📥 Text Input Box
                OutlinedTextField(
                    value = inputUrl,
                    onValueChange = { inputUrl = it },
                    placeholder = {
                        Text(
                            text = "Paste corporate link payload...",
                            color = Color.White.copy(alpha = 0.4f),
                            fontSize = 14.sp
                        )
                    },
                    textStyle = androidx.compose.ui.text.TextStyle(color = Color.White, fontSize = 14.sp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black.copy(alpha = 0.2f), RoundedCornerShape(14.dp)),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = GradientRedEnd,
                        unfocusedBorderColor = Color.Transparent,
                        cursorColor = GradientRedEnd
                    ),
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    shape = RoundedCornerShape(14.dp)
                )

                Spacer(modifier = Modifier.height(18.dp))

                // 🔴 THE FIERY GRADIENT RED ACTION BUTTON
                Button(
                    onClick = {
                        if (inputUrl.trim().isEmpty()) return@Button
                        scope.launch {
                            isProcessing = true
                            roastedUrl = ""
                            qrBitmap = null

                            val cleanUrl = inputUrl.lowercase()

                            // 🆔 Unique 5-char random generator code string
                            val allowedChars = ('a'..'z') + ('A'..'Z') + ('0'..'9')
                            val uniqueId = (1..5).map { allowedChars.random() }.joinToString("")

                            // 🎲 The 10 Wild Chaos Roasts for external links
                            val crazyRandomRoasts = listOf(
                                "dumpster-fire-url",
                                "pure-unadulterated-cringe",
                                "waste-of-internet-bandwidth",
                                "shady-scam-looking-link",
                                "nobody-asked-for-this-url",
                                "absolute-garbage-payload",
                                "highly-suspect-certified-trash",
                                "links-that-should-be-illegal",
                                "click-at-your-own-funeral",
                                "certified-digital-pollution"
                            )

                            // 🎯 FILTER CORE MATRIX: 50 Top Indian Platforms Checked
                            val roastSlug = when {
                                // Dev & Pro Tech Tools
                                cleanUrl.contains("github") -> "copy-paste-hub"
                                cleanUrl.contains("linkedin") -> "corporate-brag-club"
                                cleanUrl.contains("stackoverflow") -> "copy-paste-lifeline"
                                cleanUrl.contains("leetcode") -> "dsa-pain-simulator"

                                // E-Commerce Apps
                                cleanUrl.contains("amazon") -> "money-burner-prime"
                                cleanUrl.contains("flipkart") -> "overpriced-big-billion"
                                cleanUrl.contains("myntra") -> "out-of-stock-fashion"
                                cleanUrl.contains("meesho") -> "cheap-quality-gamble"
                                cleanUrl.contains("nykaa") -> "overpriced-makeup-scam"
                                cleanUrl.contains("olx") -> "scammer-meetup-point"
                                cleanUrl.contains("jiomart") -> "ambani-grocery-monopoly"
                                cleanUrl.contains("ajio") -> "forever-processing-delivery"

                                // Food Delivery & Quick Commerce
                                cleanUrl.contains("zomato") -> "overpriced-delivery-rainfee"
                                cleanUrl.contains("swiggy") -> "platform-fee-loot"
                                cleanUrl.contains("blinkit") -> "ten-min-panic-delivery"
                                cleanUrl.contains("zepto") -> "speed-limit-violator"
                                cleanUrl.contains("instamart") -> "lazy-human-enabler"
                                cleanUrl.contains("bigbasket") -> "rotten-tomato-lottery"

                                // Banking & FinTech Apps
                                cleanUrl.contains("paytm") -> "server-down-cashless"
                                cleanUrl.contains("phonepe") -> "processing-infinite-loop"
                                cleanUrl.contains("googlepay") || cleanUrl.contains("gpay") -> "better-luck-next-time"
                                cleanUrl.contains("cred") -> "useless-coins-casino"
                                cleanUrl.contains("sbi") -> "lunch-break-simulator"
                                cleanUrl.contains("hdfc") -> "90s-netbanking-ui"
                                cleanUrl.contains("icici") -> "credit-card-spam-call"
                                cleanUrl.contains("groww") -> "portfolio-red-zone"
                                cleanUrl.contains("zerodha") -> "glitch-on-expiry-day"

                                // Social Platforms & Entertainment
                                cleanUrl.contains("instagram") || cleanUrl.contains("instagr.am") -> "fake-flex-reels"
                                cleanUrl.contains("youtube") || cleanUrl.contains("youtu.be") -> "unskippable-double-ads"
                                cleanUrl.contains("whatsapp") -> "good-morning-spam"
                                cleanUrl.contains("snapchat") -> "useless-streak-addiction"
                                cleanUrl.contains("spotify") -> "premium-begger-audio"
                                cleanUrl.contains("netflix") -> "overpriced-password-ban"
                                cleanUrl.contains("hotstar") -> "cricket-buffering-lounge"

                                // Travel, Logistics & Cabs
                                cleanUrl.contains("ola") -> "ride-cancelled-by-driver"
                                cleanUrl.contains("uber") -> "surge-pricing-scam"
                                cleanUrl.contains("rapido") -> "bike-taxi-death-race"
                                cleanUrl.contains("makemytrip") -> "hidden-convenience-fee"
                                cleanUrl.contains("redbus") -> "back-seat-jerking-motion"
                                cleanUrl.contains("irctc") -> "tatkal-ticket-heartbreak"

                                // Network Carriers
                                cleanUrl.contains("jio") -> "data-exhausted-5g-scam"
                                cleanUrl.contains("airtel") -> "premium-price-zero-network"
                                cleanUrl.contains("vodafone") || cleanUrl.contains("idea") || cleanUrl.contains("vi.") -> "no-signal-graveyard"

                                // EdTech Giants & Indian IT Service Jails
                                cleanUrl.contains("tcs") -> "mass-recruiter-bondage"
                                cleanUrl.contains("infosys") -> "seventy-hour-workweek"
                                cleanUrl.contains("wipro") -> "minimal-hike-it-jail"
                                cleanUrl.contains("cognizant") -> "bench-period-anxiety"
                                cleanUrl.contains("physicswallah") -> "emotion-selling-coaching"
                                cleanUrl.contains("byjus") -> "bankrupt-parent-scammer"
                                cleanUrl.contains("unacademy") -> "discount-code-academy"

                                // 🎲 Catch-All Randomizer Module
                                else -> crazyRandomRoasts.random()
                            }

                            // Final short link path compilation layout
                            val generatedSlug = "$roastSlug-$uniqueId"
                            roastedUrl = "roastlink.web.app/$generatedSlug"

                            // 🏁 Auto-Generate QR Code Bitmap
                            qrBitmap = generateQRCode(roastedUrl)

                            // 🌐 ASLI CLOUD STORAGE LOGIC TRIGGERED HERE
                            try {
                                val db = com.google.firebase.firestore.FirebaseFirestore.getInstance()
                                val linkData = hashMapOf(
                                    "longUrl" to inputUrl,
                                    "shortSlug" to generatedSlug,
                                    "timestamp" to com.google.firebase.Timestamp.now()
                                )

                                db.collection("links")
                                    .document(generatedSlug)
                                    .set(linkData)
                                    .addOnSuccessListener {
                                        Toast.makeText(context, "🔥 Roasted Link & QR Synced!", Toast.LENGTH_SHORT).show()
                                    }
                                    .addOnFailureListener { e ->
                                        Toast.makeText(context, "❌ Cloud Error: ${e.message}", Toast.LENGTH_SHORT).show()
                                    }
                            } catch (e: Exception) {
                                Toast.makeText(context, "⚠️ Firebase Init Error: ${e.message}", Toast.LENGTH_LONG).show()
                            }

                            isProcessing = false
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp)
                        .background(fieryRedGradient, RoundedCornerShape(28.dp)), // Pill/Capsule curve radius
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    contentPadding = PaddingValues()
                ) {
                    Text(
                        text = if (isProcessing) "🔥 BURNING..." else "🔥 BURN & ROAST URL 🔥",
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        // 📤 3. REDIRECT OUTPUT TERMINATION AREA (Visible after payload process)
        AnimatedVisibility(visible = roastedUrl.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(GlassBackground, RoundedCornerShape(24.dp))
                    .border(1.5.dp, GlassBorder, RoundedCornerShape(24.dp))
                    .padding(16.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                        Text(
                            text = "ROASTED PAYLOAD READY:",
                            color = CyanTextGlow,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    // 🩵 HIGH-LIGHTED NEON CYAN ENGINE
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                        val baseDomain = "roast.link/"
                        val roastContent = roastedUrl.removePrefix(baseDomain)

                        val highlightedText = androidx.compose.ui.text.buildAnnotatedString {
                            // 1. Normal Muted Domain Part (Slightly faded white)
                            withStyle(style = androidx.compose.ui.text.SpanStyle(color = Color.White.copy(alpha = 0.5f))) {
                                append(baseDomain)
                            }
                            // 2. Extracted Roast part in Extra Bold Neon Cyan!
                            withStyle(style = androidx.compose.ui.text.SpanStyle(
                                color = CyanTextGlow, // 🩵 Highlighting with Neon Cyan!
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 15.sp
                            )) {
                                append(roastContent)
                            }
                        }

                        Text(
                            text = highlightedText,
                            fontSize = 14.sp,
                            fontFamily = FontFamily.Monospace
                        )
                    }

                    // 🏁 Dynamic QR Code Renderer Block
                    qrBitmap?.let { bmp ->
                        Spacer(modifier = Modifier.height(14.dp))
                        Box(
                            modifier = Modifier
                                .size(140.dp)
                                .background(Color.White, RoundedCornerShape(16.dp))
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                bitmap = bmp.asImageBitmap(),
                                contentDescription = "Roasted Link QR Code",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Transparent Cyan Bordered Utility Trigger
                    Button(
                        onClick = {
                            val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                            val clip = android.content.ClipData.newPlainText("Roasted Link", roastedUrl)
                            clipboard.setPrimaryClip(clip)
                            Toast.makeText(context, "Copied!", Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(44.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        border = BorderStroke(1.5.dp, CyanTextGlow),
                        shape = RoundedCornerShape(24.dp)
                    ) {
                        Text(
                            text = "COPY TO CLIPBOARD",
                            color = CyanTextGlow,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                }
            }
        }
    }
}