# RoastLink - Advanced Cloud-Integrated Link Management System

[![Kotlin](https://img.shields.io/badge/Language-Kotlin-purple.svg?style=flat-squared&logo=kotlin)](https://kotlinlang.org/)
[![Firebase](https://img.shields.io/badge/Backend-Firebase-orange.svg?style=flat-squared&logo=firebase)](https://firebase.google.com/)
[![Platform](https://img.shields.io/badge/Platform-Android-green.svg?style=flat-squared&logo=android)](https://developer.android.com/)

---

## 📌 Project Executive Summary

| Project Overview & Core Value | App Main Interface |
| :--- | :---: |
| **RoastLink** is not an ordinary utility tool that simply minifies destination URLs. Its defining core capability is the **Dynamic Payload Injection Engine**. <br><br>Instead of traditional, generic short URLs, the architecture programmatically prefixes high-engagement, custom "roasted" and funny slugs (e.g., `click-at-your-own-funeral`, `free-virus-installer`) to the link. <br><br>This transforms standard redirection into an interactive, humorous user experience, backed by a scalable real-time cloud registry. | <img src="<img width="1080" height="2400" alt="Screenshot_2026-06-12-16-53-37-03_31ec030915219be0bbb0259dc20c43de" src="https://github.com/user-attachments/assets/b287605a-1e16-43fc-96b7-1c2ccc783a65" />
" width="240" alt="RoastLink Main Dashboard"> |

---

## 🛠️ Development Transparency & AI Collaboration

As an engineering student stepping into scalable Android development, I believe in absolute engineering transparency:
* **The Core Vision:** The architectural blueprint, system routing flow, database schemas, and end-to-end redirection pipeline were fully conceived and directed by me.
* **AI-Assisted Frontend:** To rapidly prototype the Kotlin frontend application, I efficiently leveraged Generative AI to accelerate approximately 60% of the Android client-side UI codebase.
* **Problem-Solving & Engineering:** I acted as the primary System Architect—defining requirements, managing prompt engineering, debugging strict Firebase permission roadblocks, and custom-building the lightweight web redirection server entirely by hand.

---

## ⚙️ Technical Architecture & Core Features

* **Cloud-Hosted Registry:** Native integration with **Firebase Cloud Firestore (NoSQL)** to handle real-time synchronization, document serialization, and concurrent data lookups.
* **Decoupled Redirection Server:** Built a lightweight routing engine hosted via **Firebase Hosting**, using optimized client-side JavaScript to intercept document keys and securely forward traffic.
* **Automated OS Operations:** Leverages native Android SDK APIs (`ClipboardManager`) to allow one-tap execution directly into the device operating system clipboard.

---

## 📸 Interactive System Walkthrough

<details>
  <summary><b>🔷 Click here to expand/collapse Deep-Dive Screenshots</b></summary>
  <br>
  
  ### 1. Native Mobile Client (Link Shortening Process)
  *This screen demonstrates the primary input pipeline where long-form destination URLs are validated before sending transaction payloads to Cloud Firestore.*
  <p align="center">
    <img src="<img width="1080" height="2400" alt="Screenshot_2026-06-12-16-53-37-03_31ec030915219be0bbb0259dc20c43de" src="https://github.com/user-attachments/assets/1637b5c0-a2bc-4264-8e5f-b2cd3d160d3f" />
" width="250" alt="App Home Screen View" style="border-radius: 8px; margin-bottom: 20px;">
  </p>

  ---

  ### 2. Payload Compounding (Generated Short URL)
  *The generation interface after the system completes the cryptographic UUID sub-string mapping and attaches the humorous custom prefix.*
  <p align="center">
    <img src="<img width="1080" height="2400" alt="Screenshot_2026-06-12-16-54-44-49_31ec030915219be0bbb0259dc20c43de" src="https://github.com/user-attachments/assets/b6f7782c-3f0d-4e40-833d-110bd495514f" />
" width="250" alt="Roasted Link Generation View" style="border-radius: 8px; margin-bottom: 20px;">
  </p>

  ---

  ### 3. Server-Side Edge Redirection
  *The responsive web landing platform hosted via Firebase. It intercepts path variables, queries the database, and processes real-time redirection with customized loading feedback.*
  <p align="center">
    <img src="<img width="1080" height="2400" alt="Screenshot_2026-06-12-16-55-12-57_40deb401b9ffe8e1df2f1cc5ba480b12" src="https://github.com/user-attachments/assets/9486c94c-351e-4865-acaf-5393f068dceb" />
" width="250" alt="Web Redirection Engine Loader" style="border-radius: 8px;">
  </p>
</details>

---

## 🚀 Local Installation & Deployment

### Android Studio Setup
```bash
git clone [https://github.com/prakhar061/RoastLink.git](https://github.com/prakhar061/RoastLink.git)
