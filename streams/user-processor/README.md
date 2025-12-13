## Mini-challenge

Process a list of users with ages and genders, and:

- Filter those older than 18.
- Group them by gender.
- Compute the average age using `Stream`, handling empty results with `Optional`.

### 📁 Structure
```
 src   
  ├── model  
  │   ├── User.java
  │   └── Gender.java 
  ├── service  
  │   └── UserProcessor.java  
  └── Main.java
```