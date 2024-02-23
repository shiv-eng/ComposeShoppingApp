# My Shop 🛍

My Shop is a fictional shopping application. To access the application, an account needs to be created. The main screen displays various products. Products can be filtered based on categories. In the search screen, you can search for any desired product. You can add your desired product to favorites and quickly access it from the favorites screen. In the profile screen, you can update your username, phone number, address and date of birth.

The application uses [Firebase Authentication](https://firebase.google.com/docs/auth) for user verification. Additionally, a phone number can be added. When adding a phone number, a verification code is send to the added phone number. After entering the received code in the application, the phone number gets associated with the account. User profile images are stored using [Firebase Storage](https://firebase.google.com/docs/storage). The user's address and date of birth information are stored using [Cloud Firestore](https://firebase.google.com/docs/firestore).

### <b>Setting up the second Firebase application</b> 🛠

Enter the required information in the local.properties file as specified in the provided link.


 
## Tech Stack 📚

* [Android Architecture Components](https://developer.android.com/topic/architecture)
    * [Navigation](https://developer.android.com/guide/navigation)
    * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
    * [Repository](https://developer.android.com/topic/architecture/data-layer?hl=en)
* [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
* [Room](https://developer.android.com/training/data-storage/room)
* [Retrofit](https://github.com/square/retrofit)
* [Coil](https://github.com/coil-kt/coil)
* [Firebase Auth](https://firebase.google.com/docs/auth)
* [Firebase Storage](https://firebase.google.com/docs/storage?hl=en)
* [Firebase Firestore](https://firebase.google.com/docs/firestore?hl=en)
* [Firebase Cloud Messaging](https://firebase.google.com/docs/cloud-messaging)
* [Image Cropper](https://github.com/mr0xf00/easycrop)

## Outputs 🖼

## Architecture 🏗
The app uses MVVM [Model-View-ViewModel] architecture to have a unidirectional flow of data, separation of concern, testability, and a lot more.


## API 📦
[Fake store API](https://fakestoreapi.com/)

