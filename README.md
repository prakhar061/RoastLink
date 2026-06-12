# RoastLink - Advanced Cloud-Integrated Link Management System

[![Kotlin](https://img.shields.io/badge/Language-Kotlin-purple.svg?style=flat-squared&logo=kotlin)](https://kotlinlang.org/)
[![Firebase](https://img.shields.io/badge/Backend-Firebase-orange.svg?style=flat-squared&logo=firebase)](https://firebase.google.com/)
[![Platform](https://img.shields.io/badge/Platform-Android-green.svg?style=flat-squared&logo=android)](https://developer.android.com/)

---

## 📌 Project Executive Summary

**RoastLink is NOT an ordinary utility tool that simply shortens links.**

The defining main feature of this application is its **Dynamic Payload Injection Engine** which cracks funny, suspicious-looking jokes right at the start of the generated link (e.g., `click-at-your-own-funeral`, `free-virus-installer`). This completely transforms an ordinary, boring URL redirection into an interactive, humorous experience for users.

### Key Highlights:
- **Humorous Custom Slugs:** Replaces generic string IDs with randomized roast elements.
- **High Engagement:** Adds an entertaining flavor to peer-to-peer link sharing.
- **Cloud Backend Infrastructure:** Instantly backed by an optimized redirection log registry.

---

## 📱 App Main Interface

<img width="1080" height="2400" alt="Screenshot_2026-06-12-16-53-37-03_31ec030915219be0bbb0259dc20c43de" src="https://github.com/user-attachments/assets/d4e2433c-05c6-4e49-a9a0-a8883f6fe544" />

---

## 🛠️ Development Transparency & AI Collaboration

As an engineering student stepping into scalable Android development, I believe in absolute engineering transparency:
- **The Core Vision:** The architectural blueprint, system routing flow, database schemas, and end-to-end redirection pipeline were fully conceived and directed by me.
- **AI-Assisted Frontend:** To rapidly prototype the Kotlin frontend application, I efficiently leveraged Generative AI to accelerate approximately 60% of the Android client-side UI codebase.
- **Problem-Solving & Engineering:** I acted as the primary System Architect—defining requirements, managing prompt engineering, debugging strict Firebase permission roadblocks, and custom-building the lightweight web redirection server entirely by hand.

---

## ⚙️ Technical Architecture & Core Features

- **Cloud-Hosted Registry:** Native integration with **Firebase Cloud Firestore (NoSQL)** to handle real-time synchronization, document serialization, and concurrent data lookups.
- **Decoupled Redirection Server:** Built a lightweight routing engine hosted via **Firebase Hosting**, using optimized client-side JavaScript to intercept document keys and securely forward traffic.
- **Automated OS Operations:** Leverages native Android SDK APIs (`ClipboardManager`) to allow one-tap execution directly into the device operating system clipboard.

---

## 📸 Deep-Dive Walkthrough

<details>
  <summary><b>🔷 Click here to expand/collapse More App Screenshots</b></summary>
  <br>
  
  ### 1. Native Mobile Client (Link Shortening Process)
  *This screen demonstrates the primary input pipeline where long-form destination URLs are validated before sending transaction payloads to Cloud Firestore.*
  
  <img width="1080" height="2400" alt="Screenshot_2026-06-12-16-53-37-03_31ec030915219be0bbb0259dc20c43de" src="https://github.com/user-attachments/assets/e07aaf52-893f-450d-9fcc-00fee589620e" />

  ---

  ### 2. Payload Compounding (Generated Short URL)
  *The generation interface after the system completes the cryptographic UUID sub-string mapping and attaches the humorous custom prefix.*
  
  <img width="1080" height="2400" alt="Screenshot_2026-06-12-16-54-44-49_31ec030915219be0bbb0259dc20c43de" src="https://github.com/user-attachments/assets/b9e62652-172d-4c85-ad2f-3e0491a0219c" />

  ---

  ### 3. Server-Side Edge Redirection
  *The responsive web landing platform hosted via Firebase. It intercepts path variables, queries the database, and processes real-time redirection with customized loading feedback.*
  
  <img width="1080" height="2400" alt="Screenshot_2026-06-12-16-55-12-57_40deb401b9ffe8e1df2f1cc5ba480b12" src="https://github.com/user-attachments/assets/4dfce5f1-053b-4e09-850c-d5b34797456d" />
</details>

---

## 🚀 Local Installation & Deployment

### Android Studio Setup
```bash
git clone [https://github.com/prakhar061/RoastLink.git](https://github.com/prakhar061/RoastLink.git)
