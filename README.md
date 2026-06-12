# ⚡ RoastLink: The URL Shortener with a Shady, Roasted Twist! 🌶️

[![Kotlin](https://img.shields.io/badge/Language-Kotlin-purple.svg?style=flat-squared&logo=kotlin)](https://kotlinlang.org/)
[![Firebase](https://img.shields.io/badge/Backend-Firebase-orange.svg?style=flat-squared&logo=firebase)](https://firebase.google.com/)
[![Platform](https://img.shields.io/badge/Platform-Android-green.svg?style=flat-squared&logo=android)](https://developer.android.com/)

---

## 📌 Project Executive Summary

**RoastLink is NOT an ordinary utility tool that simply shortens links.**

The defining main feature of this application is its **Dynamic Payload Injection Engine** which cracks funny, suspicious-looking jokes right at the start of the generated link (e.g., `click-at-your-own-funeral`, `free-virus-installer`). This completely transforms an ordinary, boring URL redirection into an interactive, humorous experience for users. Additionally, upon successful creation, the system instantly generates and presents a scannable **QR Code** for the roasted link, allowing seamless and fast execution across physical and digital mediums.

### Key Highlights:
- **Humorous Custom Slugs:** Replaces generic string IDs with randomized roast elements.
- **Instant QR Code Generation:** Automatically bundles the generated payload into an on-screen QR code for quick scanning.
- **High Engagement:** Adds an entertaining flavor to peer-to-peer link sharing.
- **Cloud Backend Infrastructure:** Instantly backed by an optimized redirection log registry.
  
---

## 📱 App Main Interface

<p align="center">
  <img width="400" alt="RoastLink Client Interface" src="https://github.com/user-attachments/assets/54436d67-6810-42fb-af91-cc0893682c5b" />
</p>

---

## 🛠️ Development Transparency & AI Collaboration

As an engineering student stepping into scalable Android development, I believe in absolute engineering transparency:
- **Interest vs. Time Constraints:** I have a deep interest in native Android development using Kotlin. However, balancing rigorous college schedules and academic timelines left limited hours for manual boilerplate drafting. To solve this, I leveraged Generative AI to accelerate approximately 60% to 70% of the frontend Android UI.
- **The Core Vision:** The architectural blueprint, system routing flow, database schemas, and end-to-end redirection pipeline were fully conceived, configured, and directed by me.
- **Problem-Solving & Engineering:** I acted as the primary System Architect—defining requirements, managing prompt engineering, debugging strict Firebase permission roadblocks, and custom-building the lightweight web redirection server entirely by hand.

---

## ⚙️ Technical Architecture & Core Features

- **Cloud-Hosted Registry:** Native integration with **Firebase Cloud Firestore (NoSQL)** to handle real-time synchronization, document serialization, and concurrent data lookups.
- **Decoupled Redirection Server:** Built a lightweight routing engine hosted via **Firebase Hosting**, using optimized client-side JavaScript to intercept document keys and securely forward traffic.
- **Automated OS Operations:** Leverages native Android SDK APIs (`ClipboardManager`) to allow one-tap execution directly into the device operating system clipboard.

---

## 📸 Deep-Dive Walkthrough

<details>
  <summary><h3><b>🔷 Click here to expand/collapse More App Screenshots</b></h3></summary>
  <br>
  
  ### 1. Native Mobile Client (Link Shortening Process)
  *This screen demonstrates the primary input pipeline where long-form destination URLs are validated before sending transaction payloads to Cloud Firestore.*
  
  <p align="center">
    <img width="400" alt="App Home Screen View" src="https://github.com/user-attachments/assets/5fecb5ed-b411-4e43-8f0d-c55090646c78" />
  </p>

  ---

  ### 2. Payload Compounding (Generated Short URL)
  *The generation interface after the system completes the cryptographic UUID sub-string mapping and attaches the humorous custom prefix.*
  
  <p align="center">
    <img width="400" alt="Roasted Link Generation View" src="https://github.com/user-attachments/assets/aba58e1f-58b5-4301-8282-3e3dbe0d0619" />
  </p>

  ---

  ### 3. Server-Side Edge Redirection
  *The responsive web landing platform hosted via Firebase. It intercepts path variables, queries the database, and processes real-time redirection with customized loading feedback.*
  
  <p align="center">
    <img width="400" alt="Web Redirection Engine Loader" src="https://github.com/user-attachments/assets/595b613e-b94a-45c0-a658-276590a4f71c" />
  </p>
</details>

---

## 🚀 Local Installation & Deployment

### Android Studio Setup
```bash
git clone [https://github.com/prakhar061/RoastLink.git](https://github.com/prakhar061/RoastLink.git)
```

1. Open the cloned directory structure inside **Android Studio**.
2. Download your targeted `google-services.json` from your Firebase console instance and move it directly into the root `/app` folder block.

---   

## 🕸️ Web Infrastructure Deployment

Bash
npm install -g firebase-tools
firebase login
firebase deploy --only hosting

--- 

👤 Project Author
Prakhar Sinhasar - GitHub Portfolio

This system marks my initial milestone in bridging physical mobile applications with scalable cloud computing instances. Pull requests and performance suggestions are highly welcomed!



   
