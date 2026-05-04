# 🎬 Movie Recommendation System (KNN - Java + MySQL)

A simple yet powerful **Movie Recommendation System** built using the **K-Nearest Neighbors (KNN)** algorithm.  
This project recommends a movie genre based on user input such as **rating** and **duration**.

---

## Features

-  Uses **KNN Algorithm** for recommendation
-  Calculates similarity using **Euclidean Distance**
-  Stores movie data in **MySQL database**
-  Connects Java with MySQL using **JDBC**
-  Predicts genre using **majority voting**
-  Efficient data handling using **ArrayList & Sorting**

---

##  How It Works

1. Fetch all movie data from MySQL database  
2. Take user input:
   - Rating
   - Duration  
3. Calculate distance between input and all movies  
4. Sort movies based on distance  
5. Select top **K nearest neighbors**  
6. Apply **voting** on genres  
7. Output the most frequent genre  

---

##  Algorithm Used

### K-Nearest Neighbors (KNN)

Distance Formula:

\[
distance = \sqrt{(x_2 - x_1)^2 + (y_2 - y_1)^2}
\]

Where:
- `x = rating`
- `y = duration`

---

##  Time Complexity

- Distance Calculation → **O(n)**
- Sorting → **O(n log n)**
- Overall → **O(n log n)**
- Graph : ![image alt](https://github.com/JayBhoi965/KNN-implementation-using-JDBC/blob/main/image.png)
---

##  Tech Stack

- **Language:** Java  
- **Database:** MySQL  
- **Connectivity:** JDBC  
- **Algorithm:** KNN (Machine Learning Concept)

---

##  Database Structure

### Table: `movies`

```sql
CREATE TABLE movies (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    rating DOUBLE,
    duration INT,
    genre VARCHAR(50),
    language VARCHAR(50)
);
