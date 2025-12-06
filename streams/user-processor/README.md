## Mini-challenge

Process a list of users with ages and genders, and:

- Filter those older than 18.
- Group them by gender.
- Compute the average age using `Stream`, handling empty results with `Optional`.

### Iterations and improvements

1. **Parallelize** using `parallelStream` and measure execution time.
2. **Add generic support:** turn the method into a generic one that works with any list type.
3. **Extend:** add pagination using `skip()` and `limit()`.

### 📁 Structure
```
src   
  ├── model  
  │   └── User.java  
  ├── service  
  │   └── UserProcessor.java  
  ├── util  
  │   └── TimerUtil.java  
  └── Main.java
```