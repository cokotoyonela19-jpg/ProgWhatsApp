# ProgWhatsApp
creating a software that is testable, scalable, and maintainable.

---

## Files Overview

### 1. `Login.java`
Stores user details and validates registration/login rules.

**Fields**
- `firstName`, `lastName`, `username`, `password`, `cellPhone`
- `registered`, `lastLoginSuccessful`

**Validation Methods**
| Method | Rule |
|--------|------|
| `checkUserName()` | Contains `_` and length ≤ 5 |
| `checkPasswordComplexity()` | ≥ 8 chars, 1 uppercase, 1 digit, 1 special char |
| `checkCellPhoneNumber()` | Matches `^\+\d{1,3}\d{1,10}$` (international code + up to 10 digits) |

**Key Behaviours**
- `registerUser()` – validates all fields; sets `registered` flag; returns status message.
- `loginUser(String, String)` – compares stored vs entered credentials.
- `returnLoginStatus(boolean)` / `returnLoginStatus()` – returns welcome or error message.
- All setters use `cleanValue()` (null-safe trim).

### 2. `ProgWhatsApp.java`
The application entry point (`exec.mainClass` in `pom.xml`).

```xml
<exec.mainClass>com.mycompany.progwhatsapp.ProgWhatsApp</exec.mainClass>

---

## Files Overview

### 1. `Login.java`
Stores user details and validates registration/login rules.

**Fields**
- `firstName`, `lastName`, `username`, `password`, `cellPhone`
- `registered`, `lastLoginSuccessful`

**Validation Methods**
| Method | Rule |
|--------|------|
| `checkUserName()` | Contains `_` and length ≤ 5 |
| `checkPasswordComplexity()` | ≥ 8 chars, 1 uppercase, 1 digit, 1 special char |
| `checkCellPhoneNumber()` | Matches `^\+\d{1,3}\d{1,10}$` (international code + up to 10 digits) |

**Key Behaviours**
- `registerUser()` – validates all fields; sets `registered` flag; returns status message.
- `loginUser(String, String)` – compares stored vs entered credentials.
- `returnLoginStatus(boolean)` / `returnLoginStatus()` – returns welcome or error message.
- All setters use `cleanValue()` (null-safe trim).

### 2. `ProgWhatsApp.java`
The application entry point (`exec.mainClass` in `pom.xml`).

```xml
<exec.mainClass>com.mycompany.progwhatsapp.ProgWhatsApp</exec.mainClass>
