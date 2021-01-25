<html>
<head>
<title>Calculator</title>
</head>
<body>
    <h2>Calculator</h2>
    <p><font color="red">${errorMessage}</font></p>
    <form action="/spring-mvc-assignment/calculator" method="POST">
        Number 1 : <input name="num1" type="text" placeholder="Enter num1"/>
        <br>
        Number 2 : <input name="num2" type="text" placeholder="Enter num2" />
        <br>
        Operation : <select name="operation">
            <option value="+">Addition</option>
            <option value="-">Subtraction</option>
            <option value="*">Multiply</option>
            <option value="/">Divide</option>
        </select>
        <br>
        <input type="submit" />
    </form>
</body>
</html>