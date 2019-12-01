Copyright 2019
Manolea Dragos-Gabriel
324CA

							Etapa 1 - League of OOP

	Structura arhivei:
		- Main.java -> programul principal
		- GameInput.java + GameInputLoader -> clasele pentru citirea datelor de intrare
		- package heroes:
			- Clasa Player este clasa parinte, fiind extinsa de clasele Knight, Pyromance, Rogue si Wizard
			- Clasa PlayerCreator foloseste Factory Pattern


	Double Dispatch:
		- am folosit Double Dispatch pentru atacurile dintre doi jucatori, stiind la runtime tipurile jucatorilor care ataca si care sunt atacati. Ceva fin ;)

	Harta este o matrice de char-uri, in care retin litera corespunzatoare terenului, pentru a acorda bonusuri unde si cand este cazul.

	Metoda move<*>() are rolul de a plimba jucatorii pe harta daca acestia nu sunt imobilizati de vreun Damage Overtime.

	Batalii:
		- parcurg vectorul de playeri in fiecare runda, iar dupa ce sunt efectuate mutarile verific daca doi jucatori se afla in aceeasi casuta. In caz afirmativ, folosind double dispatch calculez damage-ul pe care acesti l-ar da, dupa care le voi scadea damage-ul incasat.


	Dupa ce s-au terminat toate rundele, afisez vectorul de playeri in fisierul de iesire conform regulilor din enunt.

	Multumesc pentru atentia acordata!


