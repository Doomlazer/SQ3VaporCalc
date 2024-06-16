;;; Sierra Script 1.0 - (do not remove this comment)
(script# 68)
(include sci.sh)
(use Main)
(use Cycle)
(use Game)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm068 0
)

(instance rm068 of Rm
	(properties
		picture 68
		horizon 85
		north 64
		west 67
	)
	
	(method (init &tmp [temp0 50])
		(proc0_3)
		(self setRegions: 600)
		(Load rsVIEW 90)
		(spew1 init:)
		(super init:)
		(TheMenuBar draw:)
		(SL enable:)
		(switch gNorth
			(64 (gEgo init:))
			(67
				(gEgo
					posn: 2 (if (< (gEgo y?) 87) 87 else (gEgo y?))
					init:
				)
				(gEgo
					posn: 2 (if (> (gEgo y?) 185) 185 else (gEgo y?))
				)
			)
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
					(gEgo setPri: 7 posn: (gEgo x?) (+ (gEgo y?) 2))
					(= global180 1)
				)
				((or (== gEgoOnControl 5) (== gEgoOnControl 7))
					(gEgo setPri: 5 posn: (+ (gEgo x?) 12) (gEgo y?))
					(= global180 1)
				)
				(
				(or (== gEgoOnControl 9) (== gEgoOnControl 13))
					(gEgo setPri: 3 posn: (+ (gEgo x?) 10) (gEgo y?))
					(= global180 1)
				)
				(
				(or (== gEgoOnControl 17) (== gEgoOnControl 49))
					(gEgo setPri: 7 posn: (gEgo x?) (- (gEgo y?) 2))
					(= global180 1)
				)
				((== gEgoOnControl 33)
					(gEgo setPri: 9 posn: (gEgo x?) (+ (gEgo y?) 2))
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

(instance SpewScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 5 10)))
			(1 (spew1 setCycle: End self))
			(2
				(spew2 init: setCycle: End self)
				(spew1 setCel: 0)
			)
			(3
				(spew2 dispose:)
				(self changeState: 0)
			)
		)
	)
)

(instance spew1 of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 90
			setLoop: 3
			setCel: 0
			cycleSpeed: 1
			posn: 90 21
			setScript: SpewScript
			ignoreActors:
		)
	)
)

(instance spew2 of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 90
			setLoop: 4
			setCel: 0
			cycleSpeed: 1
			posn: 174 0
			ignoreActors:
		)
	)
)
