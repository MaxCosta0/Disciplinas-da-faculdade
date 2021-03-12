--Exercicio 1
dobro :: Int -> Int
dobro x = 2*x

quadruplo :: Int -> Int  
quadruplo x = dobro((dobro x)) 

hipotenusa :: Float -> Float -> Float
hipotenusa cateto1 cateto2 = sqrt(cateto1 ** 2 + cateto2 ** 2)

distancia :: Float -> Float -> Float-> Float -> Float
distancia xa ya xb yb = sqrt( (xb-xa)^2 + (yb-ya)^2 )

--Exercicio 3
conversao :: Float -> (Float, Float, Float)
conversao montante = (montante, 3.96*montante, 4.45*montante);

--Exercicio 4
bissexto :: Int -> Bool
bissexto ano
  | (mod ano 4 == 0) && (mod ano 100 /= 0) = True
  | (mod ano 100 == 0) && (mod ano 400 == 0) = True
  | otherwise = False

--Exercicio 5
type Data = (Int, Int, Int)

bissexto2 :: Data -> Bool
bissexto2 (dia, mes, ano) = bissexto ano

--Exercicio 6
valida :: Data -> Bool
valida (dia, mes, ano) = if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) && (dia > 0 && dia <= 31) then True
else if(mes == 4 || mes == 6 || mes == 9 || mes == 11) && (dia > 0 && dia <= 30) then True
else if(mes == 2) && ( (bissexto2 (dia, mes, ano) && (dia > 0 && dia <=29) ) || (dia > 0 && dia <= 28) ) then True
else False

--Exercicio 7
precede :: Data -> Data -> Bool
precede (d1, m1, a1) (d2, m2, a2)
  | d1 < d2 && m1 <= m2 && a1 <= a2 = True
  | otherwise = False

--Exercicio 8
type Livro = (String, String, String, String, Int)
type Aluno = (String, String, String, String)
type Emprestimo = (String, String, Data, Data, String)

--Exercicio 9
e1::Emprestimo
e1 = ("H123C9","BSI200945",(12,9,2009),(20,9,2009),"aberto")

verificaEmprestimo :: Emprestimo -> Data -> String
verificaEmprestimo (codigoLivro, codigoAluno, dataEmprestimo, dataDevolucao, status) dataAtual
   | precede dataAtual dataEmprestimo || precede dataDevolucao dataEmprestimo = "Dados incorretos."
   | precede dataAtual dataDevolucao = "Em dia."
   | otherwise = "Atrasado."
