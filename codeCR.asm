PGM2		START 	0
			USING 	* , 15
			LA 		15 , SETUP
			SR		TOTAL , TOTAL
AC 			EQU 	2
INDEX 		EQU 	3
TOTAL 		EQU 	4
DATABASE 	EQU 	13
SETUP 		EQU 	*
			USING 	SETUP , 15
			L 		DATABASE , =A(DATA1)
			USING 	DATAAREA , DATABASE
			SR 		INDEX , INDEX
LOOP 		L 		AC , DATA1(INDEX)
			AR 		TOTAL , AC
			A 		AC , =F’5’
			ST 		AC , SAVE(INDEX)
			A 		INDEX , =F’4’
			C 		INDEX , =F’8000’
			LR 		1 , TOTAL
			LTORG
SAVE 		DS 		2000F
DATAAREA 	EQU 	*
DATA1 		DC 		F’25’
			END
