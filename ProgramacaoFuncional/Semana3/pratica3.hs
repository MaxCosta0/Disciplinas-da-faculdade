--Maxley Soares da Costa
--11911BCC038

--Exercicio 1
ou1 :: Bool -> Bool -> Bool
ou1 True  True = True
ou1 True  False = True
ou1 False  True = True
ou1 False  False = True

ou2 :: Bool -> Bool -> Bool
ou2 False False  = False
ou2 _  _ = True

ou3 :: Bool -> Bool -> Bool
ou3 False  b = b
ou3 True  _ = True

ou4 :: Bool -> Bool -> Bool
ou4 x y = if x == True || y == True then True
          else False 

ou5 :: Bool -> Bool -> Bool
ou5 x y
  | x == True || y == True = True
  | otherwise = False

--Exercicio 2
distancia :: (Float, Float) -> (Float, Float) -> Float
distancia (x, y) (x1, y1) = sqrt( ((x1-x)**2) + ((y1-y)**2) )

--Exercicio 3
fatorial :: Int -> Int
fatorial x
 | x == 0 = 1
 | otherwise = x * fatorial (x-1)

fatorial1 :: Int -> Int
fatorial1 0 = 1
fatorial1 x = x * fatorial1(x-1)

--Exercicio 4
fibo :: Int -> Int
fibo x
 | x == 0 = 0
 | x == 1 = 1
 | otherwise = fibo(x-1) + fibo(x-2)

--Exercicio 5
triangular :: Int -> Int
triangular x
 | x == 0 = 0
 | otherwise = x + triangular(x-1)

--Exercicio 6
potencia2 :: Int -> Int
potencia2 x
 | x == 0 = 1
 | otherwise = 2 * potencia2 (x-1)

--Exercicio 7
prodIntervalo :: Int -> Int -> Int
prodIntervalo m n
 | m == n = n
 | otherwise = n * prodIntervalo m(n-1)

fatorial2 :: Int -> Int
fatorial2 x
 |x == 0 = 1
 |otherwise = prodIntervalo 1 x

--Exercicio 8
resto_div :: Int -> Int -> Int
resto_div m n
 | m < n = m
 | otherwise = resto_div (m-n) n

div_inteira :: Int -> Int -> Int
div_inteira m n
 | m < n = 0
 | otherwise = 1 + div_inteira (m-n) n

--Exercicio 9
mdc :: Int -> Int -> Int
mdc m n
 | n == 0 = m
 | otherwise = mdc n (mod m n)

mdc1 :: Int -> Int -> Int
mdc1 m 0 = m
mdc1 m n = mdc1 n (mod m n)

--Exercicio 10
binomial :: Int -> Int -> Int
binomial n k
 | k > n = -1
 | k == 0 = 1
 | k == n = 1
 | otherwise = binomial (n-1) k + binomial (n-1) (k-1)

binomial1 :: Int -> Int -> Int
binomial1 n 0 = 1
binomial1 n k = if (n == k) then 1
                else if (n < k) then -1
                else binomial (n-1) k + binomial (n-1) (k-1)

--Exercicio 11
passo :: (Int, Int) -> (Int, Int)
passo (x, y) = (y, x+y)

fibo2 :: Int -> Int
fibo2 x = fiboAux x (1, 1)

fiboAux :: Int -> (Int, Int) -> Int
fiboAux x (first, second)
 | x == 1 = first
 | otherwise = fiboAux (x-1) (passo(first, second))