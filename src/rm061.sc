;;; Sierra Script 1.0 - (do not remove this comment)
(script# 61)
(include sci.sh)
(use Main)
(use Cycle)
(use Game)
(use TheMenuBar)
(use Feature)

(public
	rm061 0
)

(instance rm061 of Rm
	(properties
		picture 61
		horizon 77
		east 62
		south 67
		west 60
	)
	
	(method (init &tmp [temp0 50])
		(proc0_3)
		(self setRegions: 600)
		(Load rsVIEW 90)
		(bloop init:)
		(super init:)
		(switch gNorth
			(60
				(gEgo posn: 2 (gEgo y?) init:)
			)
			(62
				(gEgo
					view: 0
					cel: (gEgo cel?)
					loop: (gEgo loop?)
					posn: 317 (gEgo y?)
					init:
				)
			)
			(66 (gEgo posn: 80 187 init:))
			(67 (gEgo posn: 240 187 init:))
		)
		(TheMenuBar draw:)
		(SL enable:)
	)
	
	(method (doit &tmp gEgoOnControl)
		(super doit:)
		(if
			(and
				(== (global2 script?) 0)
				(or
					(== (= gEgoOnControl (gEgo onControl:)) 5)
					(== gEgoOnControl 4)
				)
			)
			(gEgo setPri: 4 posn: (gEgo x?) (- (gEgo y?) 6))
			(= global180 1)
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
			(if (== 3 (gEgo edgeHit?))
				(if (< (gEgo x?) 159)
					(= newRoomNumber 66)
				else
					(= newRoomNumber 67)
				)
			)
			(super newRoom: newRoomNumber)
		)
	)
)

(instance bloop of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 90
			setLoop: 0
			setCel: 0
			cycleSpeed: 3
			posn: 303 14
			setCycle: Fwd
			ignoreActors:
		)
	)
)
