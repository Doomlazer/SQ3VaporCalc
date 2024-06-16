;;; Sierra Script 1.0 - (do not remove this comment)
(script# 280)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Game)
(use User)
(use Obj)

(public
	rm280 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5 =  30
	[local6 12] = [27 35 43 51 59 67 91 99 123 131 139 147]
	[local18 12] = [32 40 48 56 64 72 96 104 128 136 144 152]
)
(instance rm280 of Rm
	(properties
		picture 32
	)
	
	(method (init &tmp [temp0 50])
		(Load rsPIC 32)
		(super init:)
		(= global193 1)
		(User canInput: 0 canControl: 0)
		(User mapKeyToDir: 0)
		(= global592 1)
		(gGame setCursor: global20 (HaveMouse))
		(Display
			280
			0
			dsCOORD
			10
			27
			dsWIDTH
			310
			dsCOLOR
			0
			dsFONT
			600
		)
		(Display
			280
			0
			dsCOORD
			11
			28
			dsWIDTH
			310
			dsCOLOR
			15
			dsFONT
			600
		)
		(if (== gNorth 25)
			(Display
				280
				1
				dsCOORD
				30
				175
				dsWIDTH
				200
				dsCOLOR
				0
				dsFONT
				600
			)
			(Display
				280
				1
				dsCOORD
				31
				176
				dsWIDTH
				200
				dsCOLOR
				15
				dsFONT
				600
			)
		)
		(Display
			280
			2
			dsCOORD
			200
			175
			dsWIDTH
			200
			dsCOLOR
			0
			dsFONT
			600
		)
		(Display
			280
			2
			dsCOORD
			201
			176
			dsWIDTH
			200
			dsCOLOR
			15
			dsFONT
			600
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evMOUSEBUTTON
				(cond 
					((== gNorth 25)
						(cond 
							(
								(and
									(<= 190 (pEvent x?))
									(<= (pEvent x?) 275)
									(<= 170 (pEvent y?))
									(<= (pEvent y?) 183)
								)
								(pEvent claimed: 1)
								(global2 setScript: Quitting)
							)
							(
								(and
									(<= local4 (pEvent x?))
									(<= (pEvent x?) local5)
									(<= [local6 0] (pEvent y?))
									(<= (pEvent y?) [local18 0])
								)
								(= local3 1)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (pEvent x?))
									(<= (pEvent x?) local5)
									(<= [local6 1] (pEvent y?))
									(<= (pEvent y?) [local18 1])
								)
								(= local3 2)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (pEvent x?))
									(<= (pEvent x?) local5)
									(<= [local6 2] (pEvent y?))
									(<= (pEvent y?) [local18 2])
								)
								(= local3 3)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (pEvent x?))
									(<= (pEvent x?) local5)
									(<= [local6 3] (pEvent species?))
									(<= (pEvent species?) [local18 3])
								)
								(= local3 4)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (pEvent x?))
									(<= (pEvent x?) local5)
									(<= [local6 4] (pEvent y?))
									(<= (pEvent y?) [local18 4])
								)
								(= local3 5)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (pEvent x?))
									(<= (pEvent x?) local5)
									(<= [local6 5] (pEvent y?))
									(<= (pEvent y?) [local18 5])
								)
								(= local3 6)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (pEvent x?))
									(<= (pEvent x?) local5)
									(<= [local6 6] (pEvent y?))
									(<= (pEvent y?) [local18 6])
								)
								(= local3 7)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (pEvent x?))
									(<= (pEvent x?) local5)
									(<= [local6 7] (pEvent y?))
									(<= (pEvent y?) [local18 7])
								)
								(= local3 8)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (pEvent x?))
									(<= (pEvent x?) local5)
									(<= [local6 8] (pEvent y?))
									(<= (pEvent y?) [local18 8])
								)
								(= local3 9)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (pEvent x?))
									(<= (pEvent x?) local5)
									(<= [local6 9] (pEvent y?))
									(<= (pEvent y?) [local18 9])
								)
								(= local3 10)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (pEvent x?))
									(<= (pEvent x?) local5)
									(<= [local6 10] (pEvent y?))
									(<= (pEvent y?) [local18 10])
								)
								(= local3 11)
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (pEvent x?))
									(<= (pEvent x?) local5)
									(<= [local6 11] (pEvent y?))
									(<= (pEvent y?) [local18 11])
								)
								(= local3 12)
								(global2 setScript: ChooseFood)
							)
						)
					)
					(
						(and
							(<= 190 (pEvent x?))
							(<= (pEvent x?) 275)
							(<= 170 (pEvent y?))
							(<= (pEvent y?) 183)
						)
						(pEvent claimed: 1)
						(global2 setScript: Quitting)
					)
				)
			)
			(evKEYBOARD
				(cond 
					((== gNorth 25)
						(cond 
							(
								(or
									(== (pEvent message?) KEY_Q)
									(== (pEvent message?) KEY_q)
								)
								(global2 setScript: Quitting)
							)
							(
								(and
									(>= (pEvent message?) KEY_1)
									(<= (pEvent message?) KEY_9)
								)
								(= local3 (- (pEvent message?) KEY_0))
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(>= (pEvent message?) KEY_A)
									(<= (pEvent message?) KEY_C)
								)
								(= local3 (- (pEvent message?) KEY_7))
								(global2 setScript: ChooseFood)
							)
							(
								(and
									(>= (pEvent message?) KEY_a)
									(<= (pEvent message?) KEY_c)
								)
								(= local3 (- (pEvent message?) KEY_W))
								(global2 setScript: ChooseFood)
							)
						)
					)
					(
						(or
							(== (pEvent message?) KEY_Q)
							(== (pEvent message?) KEY_q)
						)
						(global2 setScript: Quitting)
					)
				)
			)
		)
	)
)

(instance ChooseFood of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local3
					(0)
					(1
						(= global244 (+ global244 1))
						(= local2 1)
					)
					(2
						(= global244 (+ global244 2))
						(= local2 1)
					)
					(3
						(= global244 (+ global244 3))
						(= local2 1)
					)
					(4
						(= global244 (+ global244 2))
						(= local2 1)
					)
					(5
						(= global244 (+ global244 5))
						(= local2 1)
					)
					(6
						(= global244 (+ global244 9))
						(= local2 1)
						(= global101 1)
					)
					(7
						(= global244 (+ global244 7))
						(if (not (gEgo has: 7)) (= global249 1))
						(= local2 1)
					)
					(8
						(= global244 (+ global244 1))
						(= local2 1)
					)
					(9
						(= global244 (+ global244 1))
						(= local1 1)
					)
					(10
						(= global244 (+ global244 2))
						(= local1 1)
					)
					(11
						(= global244 (+ global244 3))
						(= local1 1)
					)
					(12
						(= global244 (+ global244 4))
						(= local1 1)
					)
				)
				(proc255_0 280 3 67 -1 95 70 50 33 600 91)
				(= cycles 30)
			)
			(1
				(proc0_12)
				(global2 setScript: 0)
			)
		)
	)
)

(instance Quitting of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (== gNorth 25) global244)
					(if (not local1)
						(proc255_0
							280
							4
							82
							38
							4
							0
							30
							1
							80
							{Pushy Counter Clerk}
							81
							{ Yes_}
							1
							81
							{ Yes_}
							2
						)
					)
					(proc255_0
						280
						5
						82
						38
						4
						1
						30
						1
						80
						{Pushy Counter Clerk}
						81
						{ Yes_}
						1
						81
						{ Yes_}
						2
					)
					(proc255_0
						280
						6
						82
						38
						4
						2
						30
						1
						80
						{Pushy Counter Clerk}
						81
						{ Yes_}
						1
						81
						{ Yes_}
						2
					)
					(if (not local1)
						(proc255_0
							280
							7
							82
							38
							4
							0
							30
							1
							80
							{While Supplies Last}
							81
							{ Okay_}
							1
						)
					)
					(if (not local2)
						(proc255_0
							280
							8
							82
							38
							4
							0
							30
							1
							80
							{While Supplies Last}
							81
							{ Okay_}
							1
						)
					)
					(= global592 0)
					(= global193 0)
					(if (> global244 9999) (= global244 9999))
					(User mapKeyToDir: 1)
					(proc0_12)
					(global2 newRoom: 25)
				else
					(= global592 0)
					(= global193 0)
					(User mapKeyToDir: 1)
					(global2 newRoom: gNorth)
				)
			)
		)
	)
)
