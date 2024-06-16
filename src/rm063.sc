;;; Sierra Script 1.0 - (do not remove this comment)
(script# 63)
(include sci.sh)
(use Main)
(use Game)
(use TheMenuBar)

(public
	rm063 0
)

(instance rm063 of Rm
	(properties
		picture 63
		east 64
		south 67
	)
	
	(method (init &tmp [temp0 50])
		(proc0_3)
		(self setRegions: 600)
		(super init:)
		(TheMenuBar draw:)
		(SL enable:)
		(switch gNorth
			(64
				(gEgo posn: 317 (gEgo y?) init:)
			)
			(67 (gEgo posn: 80 187 init:))
		)
	)
	
	(method (doit &tmp gEgoOnControl)
		(super doit:)
		(if (== (global2 script?) 0)
			(cond 
				(
					(or
						(== (= gEgoOnControl (gEgo onControl:)) 3)
						(== gEgoOnControl 2)
					)
					(gEgo setPri: 3 posn: (gEgo x?) (- (gEgo y?) 6))
					(= global180 1)
				)
				((or (== gEgoOnControl 5) (== gEgoOnControl 7))
					(gEgo setPri: 5 posn: (- (gEgo x?) 6) (gEgo y?))
					(= global180 1)
				)
				(
				(or (== gEgoOnControl 9) (== gEgoOnControl 11))
					(gEgo setPri: 1 posn: (gEgo x?) (- (gEgo y?) 6))
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
	)
	
	(method (newRoom newRoomNumber)
		(if (== script 0)
			(if global256 (++ global593))
			(super newRoom: newRoomNumber)
		)
	)
)
