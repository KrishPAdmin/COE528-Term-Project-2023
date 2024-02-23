# COE528 (W 2023) Project

## Course Details
- **Course Title:** Object Oriented Eng Analysis and Design
- **Course Number:** COE528
- **Semester/Year:** W2023
- **Assignment/Lab Number:** Term Project

## Student Details
**Student Names:**
- Krish Patel
- Connor Collington
- Muhammad Hussain Al-lami
- Success Daka
- Mahdi Hassen

## Login Credentials
- **Owner Username:** admin
- **Owner Password:** admin
- **Default Customer Username:** john
- **Default Customer Password:** password

## Use-case: Login
### Participating Actors:
- Customer
- Owner

### Entry Condition:
- The application must open and load stored login credentials successfully.

### Flow of Events:
1. The Customer or Owner opens the book store app.
2. They fill in their username and password and click the login button.
3. The application checks the entered username and password.
4. If credentials match, the user is logged in, and the corresponding GUI is loaded.

### Exit Conditions:
- Successful login or application closure.

### Exceptions:
- Invalid login attempts.
- Null username or password entry.

### Special Requirements:
- Only one owner account per application.
- Only the Owner or a single Customer can be logged in.

## Why the State Design Pattern?
The state design pattern allows objects to change behavior depending on their current state. In this book-store application, customer status (gold or silver) determines the greeting upon login. The state pattern simplifies status representation, making it easy to update after transactions. This improves efficiency, maintainability, and upgradability.
