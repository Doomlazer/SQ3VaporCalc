;;; Sierra Script 1.0 - (do not remove this comment)
(script# 70)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Game)
(use TheMenuBar)
(use Feature)

(public
	rm070 0
)

(instance rm070 of Rm
	(properties
		picture 70
		horizon 70
		north 67
		east 71
		west 69
	)
	
	(method (init &tmp [temp0 50])
		(proc0_3)
		(self setRegions: 600)
		(Load rsVIEW 98)
		(super init:)
		(if (not global253)
			(gAddToPics add: ship)
			(gAddToPics doit:)
		)
		(switch gNorth
			(67
				(gEgo
					posn:
						(if (> (gEgo x?) 115) 115 else (gEgo x?))
						(+ (global2 horizon?) 2)
					init:
				)
			)
			(69
				(gEgo
					init:
					posn:
						2
						(cond 
							((< (gEgo y?) 85) 72)
							((== (gEgo y?) 86) 88)
							((> (gEgo y?) 166) 166)
							(else (gEgo y?))
						)
				)
			)
			(71
				(gEgo
					init:
					posn:
						317
						(cond 
							((== (gEgo y?) 84) 83)
							((and (< (gEgo y?) 127) (> (gEgo y?) 115)) 114)
							((> (gEgo y?) 142) 142)
							(else (gEgo y?))
						)
				)
			)
		)
		(TheMenuBar draw:)
		(SL enable:)
	)
	
	(method (doit &tmp gEgoOnControl)
		(super doit:)
		(if (== (global2 script?) 0)
			(cond 
				(
					(or
						(== (= gEgoOnControl (gEgo onControl:)) 3)
						(== gEgoOnControl 7)
					)
					(gEgo
						setPri: 8
						posn: (+ (gEgo x?) 2) (gEgo y?)
						illegalBits: 0
					)
					(= global180 1)
				)
				((== gEgoOnControl 17)
					(gEgo
						setPri: 13
						posn: (+ (gEgo x?) 2) (gEgo y?)
						illegalBits: 0
					)
					(= global180 1)
				)
				((== gEgoOnControl 9)
					(gEgo
						setPri: 11
						posn: (+ (gEgo x?) 2) (gEgo y?)
						illegalBits: 0
					)
					(= global180 1)
				)
				((== gEgoOnControl 5)
					(gEgo
						setPri: 14
						posn: (gEgo x?) (+ (gEgo y?) 2)
						illegalBits: 0
					)
					(= global180 1)
				)
			)
		)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'look/rock,boulder') (proc255_0 70 0))
			((Said 'look/scout,craft,skull,bow') (if global253 (proc255_0 70 1) else (proc255_0 70 2)))
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (not script)
			(if global256 (++ global593))
			(super newRoom: newRoomNumber)
		)
	)
)

(instance ship of PV
	(properties
		y 135
		x 66
		view 98
		priority 9
		signal $4000
	)
)
