--Maxley Soares da Costa
--11911BCC038

--Questao 1

type Data = (Int, Int, Int)
type Emprestimo = (String, String, Data, Data, String)
type Emprestimos = [Emprestimo]
bdEmprestimo :: Emprestimos

bdEmprestimo =
 [("H123C9","BSI945",(12,9,2009),(20,09,2009),"aberto"),
 ("L433C5","BCC021",(01,9,2009),(10,09,2009),"encerrado"),
 ("M654C3","BCC008",(04,9,2009),(15,09,2009),"aberto")]

--a
valida :: Data -> Bool
valida (dia, mes, ano)
  | dia < 1 || dia > 31 = False
  | elem mes m31 && dia <= 31 = True
  | elem mes m30 && dia <= 30 = True
  | (mes == 2 && dia <= 28) || (bissexto ano && mes == 2 && dia <= 29) = True
  | otherwise = False
  where
    m31 = [1, 3, 5, 7, 8, 10, 12];
    m30 = [4, 6, 9, 11]
    bissexto :: Int -> Bool
    bissexto x
      | (mod x 4 == 0) && (mod x 100 /= 0) = True
      | mod x 400 == 0 = True
      | otherwise = False

--b
bissextos :: [Int] -> [Int]
bissextos lista = [ano | ano <- lista, bissexto ano]
  where
    bissexto :: Int -> Bool
    bissexto x
      | (mod x 4 == 0) && (mod x 100 /= 0) = True
      | mod x 400 == 0 = True
      | otherwise = False

--c
atrasados :: Emprestimos -> Data -> Emprestimos
atrasados bdEmprestimo dataAtual = [x | x <- bdEmprestimo, atrasado x dataAtual]
  where
    atrasado :: Emprestimo -> Data -> Bool
    atrasado (_, _, _, dataDevolucao, situacao) dataAtual
      | posterior dataAtual dataDevolucao && situacao == "aberto" = True
      | otherwise = False

    posterior :: Data -> Data -> Bool
    posterior (d1, m1, a1) (d2, m2, a2)
      | d1 > d2 && m1 >= m2 && a1 >= a2 = True
      | m1 > m2 && a1 >= a2 = True
      | a1 > a2 = True
      | otherwise = False

--d
fibo :: Int -> Int
fibo x = fiboAux x (1, 1)
  where
    fiboAux :: Int -> (Int, Int) -> Int
    fiboAux x (first, second)
      | x == 1 = first
      | otherwise = fiboAux (x-1) (passo(first, second))

    passo :: (Int, Int) -> (Int, Int)
    passo (x, y) = (y, x+y)

--e
fatorial :: Int -> Int
fatorial x
  | x == 0 = 1
  | otherwise = prodIntervalo 1 x
  where
    prodIntervalo :: Int -> Int -> Int
    prodIntervalo m n
      | m == n = n
      | otherwise = n * prodIntervalo m(n-1)

--Questao 2

--a
valida2 :: Data -> Bool
valida2 (dia, mes, ano) = let

  m31 = [1, 3, 5, 7, 8, 10, 12]
  m30 = [4, 6, 9, 11]

  bissexto :: Int -> Bool
  bissexto x
    | (mod x 4 == 0) && (mod x 100 /= 0) = True
    | mod x 400 == 0 = True
    | otherwise = False

  in

    if( (elem mes m31 && dia <= 31) || (elem mes m30 && dia <= 30) || (mes == 2 && dia <= 28) || (bissexto ano && mes == 2 && dia <= 29)) then True
    else False

--b
bissextos2 :: [Int] -> [Int]
bissextos2 lista = let

  bissexto :: Int -> Bool
  bissexto x
    | (mod x 4 == 0) && (mod x 100 /= 0) = True
    | mod x 400 == 0 = True
    | otherwise = False

  in

    [ano | ano <- lista, bissexto ano]

--c
atrasados2 :: Emprestimos -> Data -> Emprestimos
atrasados2 bdEmprestimo dataAtual = let

  atrasado :: Emprestimo -> Data -> Bool
  atrasado (_, _, _, dataDevolucao, situacao) dataAtual
    | posterior dataAtual dataDevolucao && situacao == "aberto" = True
    | otherwise = False

  posterior :: Data -> Data -> Bool
  posterior (d1, m1, a1) (d2, m2, a2)
      | d1 > d2 && m1 >= m2 && a1 >= a2 = True
      | m1 > m2 && a1 >= a2 = True
      | a1 > a2 = True
      | otherwise = False

  in

    [x | x <- bdEmprestimo, atrasado x dataAtual]

--d
fibo2 :: Int -> Int
fibo2 x = let
  fiboAux :: Int -> (Int, Int) -> Int
  fiboAux x (first, second)
    | x == 1 = first
    | otherwise = fiboAux (x-1) (passo(first, second))

  passo :: (Int, Int) -> (Int, Int)
  passo (x, y) = (y, x+y)

  in

    fiboAux x (1, 1)

--e
fatorial2 :: Int -> Int
fatorial2 x = let
  prodIntervalo :: Int -> Int -> Int
  prodIntervalo m n
    | m == n = n
    | otherwise = n * prodIntervalo m(n-1)
  
  in
    
    if(x == 0) then 1 else prodIntervalo 1 x

--Questao 5

--a
letraA = (\x -> \y -> y) ((\z -> z)(\z -> z)) (\w -> w) 5

--b
letraB = ((\f -> (\x -> f(f x)))(\y -> (y*y))) 3

--c
letraC = ((\f -> (\x -> f(f x)))(\y -> ((+) y y))) 5

--d
letraD = ((\x -> (\y -> (+) x y) 5)((\y -> (-) y 3) 7))

--e
letraE = (((\f -> (\x -> f(f(f x))))(\y -> (y * y))) 2)

--f
letraF = (\x -> \y -> (+) x ((\x -> (-) x 3) y)) 5 6