--Maxley Soares da Costa
--11911BCC038

--Questao 1
paridade :: [Int] -> [Bool]
paridade l = map even l

--Questao 2
prefixo3 :: Int -> String -> String
prefixo3 0 _ = []
prefixo3 _ [] = []
prefixo3 k (x:xs) = x : prefixo3 (k-1) xs

prefixos :: [String] -> [String]
prefixos l = map (prefixo3 3) l

--Questao 3
saudacao :: [String] -> [String]
saudacao l = map ("Oi " ++ ) l

--Questao 4
filtrar :: (a -> Bool) -> [a] -> [a]
filtrar f l = [x | x <- l, f x]

--Questao 5
pares :: [Int] -> [Int]
pares lst = filter even lst

--Questao 6
f k = (\x -> 5 * x + 6) k
g k = (\x -> x * x) k

gMaiorQuef :: Int -> Bool
gMaiorQuef x = g x > f x

solucoes :: [Int] -> [Int]
solucoes l = filter gMaiorQuef l

--Questao 7
maior :: [Int] -> Int
maior l = foldr1 max l

--Questao 8
menor_min10 :: [Int] -> Int
menor_min10 l = foldr min 10 l

--Questao 9
junta_silabas_plural :: [String] -> String
junta_silabas_plural l = foldr (++) "s" l

--Questao 10
menores10 :: [Int] -> ([Int], Int)
menores10 l = let valores = filter (<10) l in (valores, length valores)

--Questao 11
posicao_elemento :: Int -> [Int] -> Int -> Int
posicao_elemento _ [] posAtual = posAtual-1
posicao_elemento k (x:xs) posAtual
  | k == x = posAtual
  | otherwise = posicao_elemento k xs (posAtual+1)

busca_elem :: Int -> [Int] -> (Bool, Int)
busca_elem x l = let pos = posicao_elemento in ((elem x l), pos x l 1)