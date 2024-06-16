;;; Sierra Script 1.0 - (do not remove this comment)
(script# 60)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm060 0
)

(instance rm060 of Rm
	(properties
		picture 60
		horizon 77
		east 61
		south 66
	)
	
	(method (init &tmp [temp0 50])
		(proc0_3)
		(self setRegions: 600)
		(Load rsVIEW 96)
		(super init:)
		(bigBub init:)
		(smallBub init:)
		(switch gNorth
			(61
				(gEgo posn: 317 (gEgo y?) init:)
			)
			(66
				(gEgo
					posn: (if (< (gEgo x?) 125) 125 else (gEgo x?)) 187
					init:
				)
			)
		)
		(TheMenuBar draw:)
		(SL enable:)
	)
	
	(method (doit &tmp gEgoOnControl [temp1 50])
		(super doit:)
		(if (not (global2 script?))
			(cond 
				(
					(or
						(== (= gEgoOnControl (gEgo onControl:)) 3)
						(== gEgoOnControl 2)
						(== gEgoOnControl 7)
					)
					(gEgo setPri: 3 posn: (gEgo x?) (- (gEgo y?) 2))
					(= global180 1)
				)
				(
				(or (== gEgoOnControl 5) (== gEgoOnControl 13))
					(gEgo setPri: 5 posn: (- (gEgo x?) 6) (gEgo y?))
					(= global180 1)
				)
				((== gEgoOnControl 9)
					(gEgo setPri: 7 posn: (gEgo x?) (- (gEgo y?) 2))
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
		(if (Said 'look/bubble') (proc255_0 60 0))
	)
	
	(method (newRoom newRoomNumber)
		(if (not script)
			(if global256 (++ global593))
			(super newRoom: newRoomNumber)
		)
	)
)

(instance BigBubble of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 1 2)))
			(1
				(bigBub
					posn: (Random 14 320) (Random 132 194)
					setCycle: End self
				)
			)
			(2
				(bigBub setCel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance SmallBubble of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 1))
			(1
				(smallBub
					posn: (Random 143 320) (Random 81 106)
					setCycle: End self
				)
			)
			(2
				(smallBub setCel: 0)
				(self changeState: 0)
			)
		)
	)
)

(instance bigBub of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 96
			setLoop: 0
			setCel: 0
			setPri: 2
			setScript: BigBubble
			ignoreActors: 1
		)
	)
)

(instance smallBub of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 96
			setLoop: 1
			setCel: 0
			setPri: 2
			setScript: SmallBubble
			ignoreActors: 1
		)
	)
)
