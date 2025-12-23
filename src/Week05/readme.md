# תרגילי תכנות גנרי בג׳אווה (Generics)

להלן כל התרגילים, מסודרים ברצף אחד ללא חלוקה לחלקים, כך שהמסמך יהיה אחיד וקריא.

---

### **שאלה 1 — מחלקה גנרית בסיסית**
כתוב מחלקה גנרית בשם `Box<T>` המאפשרת לאחסן ערך אחד מכל סוג.  
המחלקה תכיל:
- שדה פרטי מסוג `T`
- בנאי מלא
- `setValue(T value)`
- `getValue()`
- מימוש `toString()`

**שאלת המשך:**  
צור מופעים של `Box<Integer>` ו־`Box<String>` והדפס את הערך של כל אחד.

---

### **שאלה 2 — מחלקה גנרית עם שני טיפוסים**
כתוב מחלקה גנרית בשם `Pair<K,V>` המייצגת זוג של ערכים מטיפוסים שונים.  
המחלקה תכלול:
- שני שדות `K key`, `V value`
- בנאי מלא
- getters
- `toString()`

**שאלת המשך:**  
צור אובייקט `Pair<String, Integer>` עבור שם וגיל.

---

### **שאלה 3 — פונקציה גנרית להדפסת מערכים**
כתוב מתודה גנרית סטטית בשם `printArray` שמקבלת מערך מכל סוג ומדפיסה כל איבר.

```java
printArray(new Integer[]{1, 2, 3});
printArray(new String[]{"A", "B", "C"});
```

---

### **שאלה 4 — Upper Bound Wildcards**
כתוב מתודה גנרית `sumNumbers` שמקבלת רשימה מכל סוג שיורש מ־`Number`:

```java
List<? extends Number>
```

הפונקציה תחזיר סכום של כל המספרים כ־`double`.

---

### **שאלה 5 — Lower Bound Wildcards**
כתוב מתודה `addIntegers` שמקבלת:

```java
List<? super Integer>
```

המתודה תוסיף לרשימה את המספרים 1 עד 5.

---

### **שאלה 6 — מחלקה גנרית עם מגבלת טיפוס**
כתב מחלקה גנרית:

```java
public class NumericBox<T extends Number>
```

המחלקה תכיל:
- שדה `T value`
- בנאי מלא
- `getValue()`
- פעולה `doubleValueTimesTwo()` שמחזירה `value.doubleValue() * 2`.

---

### **שאלה 7 — העתקת רשימות עם Wildcards**
כתוב פונקציה גנרית בשם `copyList`:

```java
copyList(List<? extends T> source, List<? super T> dest)
```

הפונקציה תעביר את כל הערכים מרשימת המקור ליעד.

---

### **שאלה 8 — מחלקה גנרית שמממשת ממשק**
הממשק:

```java
public interface Identifiable<T> {
    T getId();
}
```

מחלקת `User<ID>` תממש אותו וכוללת:
- מזהה `ID`
- שם משתמש
- בנאי מלא
- מימוש `getId()`
- `toString()`

---

### **שאלה 9 — מחלקת Repository גנרית**
```java
public class Repository<T extends Identifiable<?>>
```

המחלקה תנהל רשימה של אובייקטים ותתמוך ב:
- `add(T item)`
- `removeById(Object id)`
- `findById(Object id)`

---

### **שאלה 10 — Multiple Bounds**
```java
public abstract class Shape {
    public abstract double area();
}

public interface Drawable {
    void draw();
}
```

מחלקה גנרית:

```java
public class ShapeHandler<T extends Shape & Drawable>
```

תכיל:
- `printArea(T shape)`
- `drawShape(T shape)`

---

### **שאלה 11 — Stack<T> גנרי**
מימוש מחסנית גנרית עם:
- מערך פנימי
- `push`
- `pop`
- `peek`
- `isEmpty`

---

### **שאלה 12 — מתודה גנרית עם Comparable**
```java
public static <T extends Comparable<T>> T findMax(T[] array)
```
המתודה תחזיר את הערך הגדול ביותר במערך.

---

### **שאלה 13 — Builder גנרי**
```java
public interface Supplier<T> {
    T get();
}
```

מחלקת `Builder<T>` תאפשר יצירת אובייקטים גנרית.