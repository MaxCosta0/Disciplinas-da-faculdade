--Maxley Soares da Costa
--11911BCC038

--Questao 3
--Devolve todos os numeros dentro do intervalo a b 
intervalo :: Int -> Int -> [Int]
intervalo a b = [a..b]

--Pega os elementos pares que a função pares nao dá
pegaPares :: [Int] -> [Int]
pegaPares [] = []
pegaPares lista
 | even (head lista) = [head lista] ++ pegaPares (tail lista)
 | otherwise = pegaPares (tail lista)

--Devolve os numeros pares do intervalo aberto (a, b)
pares :: Int -> Int -> [Int]
pares a b
 | a == b = []
 | otherwise = pegaPares [(a+1)..(b-1)]


--Questao 4
lst1 = [x*2 | x <- [1..10], x*2 >= 12]
lst2 = [ x | x <- [50..100], mod x 7 == 3]
lst3 = [ x | x <- [10..20], x /= 13, x /= 15, x /= 19]
lst4 = [(x,y)| x <- [1..4], y <- [x..5]]

--Questao 5
--Retorna todos os valores entre a e b ao quadrado
quadrados :: Int -> Int -> [Int]
quadrados a b = [x^2 | x <- [a..b]]

--Questao 6
--Retorna uma todos os numeros impares de uma lista
seleciona_impares :: [Int] -> [Int]
seleciona_impares lista = [x | x <- lista, odd(x)]

--Questao 7
--Retorna os 10 primeiros multiplos do numero dado
tabuada :: Int -> [Int]
tabuada x = [x*n | n <- [1..10]]

--Questao 8
--Verifica se um dado ano é bissexto
bissexto :: Int -> Bool
bissexto ano
  | (mod ano 4 == 0) && (mod ano 100 /= 0) = True
  | (mod ano 100 == 0) && (mod ano 400 == 0) = True
  | otherwise = False

--Devolve os anos bissextos de uma dada lista de anos
bissextos :: [Int] -> [Int]
bissextos lista = [ano | ano <- lista, bissexto ano]

--Questao 9
--Dada uma lista de listas, devolve todo o conteudo 
--em apenas uma lista de nivel mais alto
sublistas :: [[Int]] -> [Int]
sublistas lista = [x | x <- concat lista]

--Questao 10
type Data = (Int, Int, Int)
type Emprestimo = (String, String, Data, Data, String)
type Emprestimos = [Emprestimo]
bdEmprestimo :: Emprestimos

bdEmprestimo =
 [("H123C9","BSI945",(12,9,2009),(20,09,2009),"aberto"),
 ("L433C5","BCC021",(01,9,2009),(10,09,2009),"encerrado"),
 ("M654C3","BCC008",(04,9,2009),(15,09,2009),"aberto")]

--Dada a data prevista para devolução e a data atual, 
--verifica se um item esta em atraso
verificaAtraso :: Emprestimo -> Data -> Bool
verificaAtraso (_, _, _, (d1, m1, a1), _) (d2, m2, a2)
 | d1 <= d2 && m1 <= m2 && a1 <= a2 = True
 | m1 < m2 || a1 < a2 = True
 | otherwise = False


--Devolve uma lista com os emprestimos atrasados
atrasados :: Emprestimos -> Data -> Emprestimos
atrasados bdEmprestimo dataAtual = [x | x <- bdEmprestimo, verificaAtraso x dataAtual]

--Questao 11
--Dadas 2 listas, retorna os elementos da segunda lista
--que nao estao contidos na primeira
nao_repetidos  :: [Int] -> [Int] -> [Int]
nao_repetidos lista1 lista2 = [x | x <- lista2, not (elem x lista1)]

--Concatena todos os elementos da lista 1 com os
--elementos da lista 2 que nao pertencem à lista 1
uniaoNRec :: [Int] -> [Int] -> [Int]
uniaoNRec lista1 lista2 = lista1 ++ (nao_repetidos lista1 lista2)
