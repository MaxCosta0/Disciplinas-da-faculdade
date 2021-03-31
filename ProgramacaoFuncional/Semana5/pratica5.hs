--Maxley Soares da Costa
--11911BCC038

--Questao 1
conta_ch :: [Char] -> Int
conta_ch [] = 0
conta_ch (x:xs) = 1 + conta_ch xs

conta :: [a] -> Int
conta [] = 0
conta (x:xs) = 1 + conta xs

maior :: [Int] -> Int
maior [x] = x
maior (x:y:xs)
 | x > y = maior (x:xs)
 | otherwise = maior (y:xs)

primeiros :: Int -> [a] -> [a]
primeiros 0 _ = []
primeiros _ [] = []
primeiros n (x:xs) = x : primeiros (n-1) xs

pertence :: Eq a  => a -> [a] -> Bool
pertence _ [] = False
pertence elemento (x:xs)
 | elemento == x = True
 | otherwise = pertence elemento xs

uniaoR :: Eq a => [a] -> [a] -> [a]
uniaoR [] [] = []
uniaoR [] l = l
uniaoR (x:xs) l
 | pertence x l = uniaoR xs l
 | otherwise = x : uniaoR xs l


--Questao 2
npares :: [Int] -> Int
npares [] = 0 
npares (x:xs)
 | even x = 1 + npares xs
 | otherwise = npares xs

--Questao 3
produtorio :: [Float] -> Float
produtorio [x] = x
produtorio (x:xs) = x * produtorio xs

--Questao 4
comprime :: Eq a => [[a]] -> [a]
comprime [] = []
comprime (x:xs) = x ++ comprime xs

--Questao 5
tamanho :: Eq a => [a] -> Int
tamanho [] = 0
tamanho (x:xs) = 1 + tamanho xs

--Questao 6
uniaoRec2_aux :: Eq a => [a] -> [a] -> [a]
uniaoRec2_aux _ [] = []
uniaoRec2_aux l1 (x:xs)
 | pertence x l1 = uniaoRec2_aux l1 xs
 | otherwise = x : uniaoRec2_aux l1 xs

uniaoRec2 :: Eq a => [a] -> [a] -> [a]
uniaoRec2 l1 l2 = l1 ++ uniaoRec2_aux l1 l2