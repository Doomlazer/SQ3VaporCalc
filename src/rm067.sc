;;; Sierra Script 1.0 - (do not remove this comment)
(script# 67)
(include sci.sh)
(use Main)
(use Game)
(use TheMenuBar)

(public
	rm067 0
)

(instance rm067 of Rm
	(properties
		picture 67
		horizon 77
		north 62
		east 68
		south 70
		west 66
	)
	
	(method (init &tmp [temp0 50])
		(proc0_3)
		(self setRegions: 600)
		(super init:)
		(switch gNorth
			(61
				(gEgo posn: (+ (global2 horizon?) 2) 80 init:)
			)
			(62
				(gEgo view: 0 cel: (gEgo cel?) loop: (gEgo loop?) init:)
			)
			(63 (gEgo posn: 240 80 init:))
			(66
				(gEgo posn: 2 (gEgo y?) init:)
			)
			(68
				(gEgo posn: 317 (gEgo y?) init:)
			)
			(70
				(gEgo posn: (gEgo x?) 187 init:)
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
						(== gEgoOnControl 2)
					)
					(gEgo setPri: 7 posn: (gEgo x?) (+ (gEgo y?) 2))
					(= global180 1)
				)
				((== gEgoOnControl 9)
					(gEgo setPri: 7 posn: (gEgo x?) (- (gEgo y?) 2))
					(= global180 1)
				)
				((or (== gEgoOnControl 5) (== gEgoOnControl 7))
					(gEgo setPri: 5 posn: (gEgo x?) (+ (gEgo y?) 2))
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
			(if (== 1 (gEgo edgeHit?))
				(if (< (gEgo x?) 105) (= newRoomNumber 61))
				(if (> (gEgo x?) 210) (= newRoomNumber 63))
			)
			(if global256 (++ global593))
			(super newRoom: newRoomNumber)
		)
	)
)
