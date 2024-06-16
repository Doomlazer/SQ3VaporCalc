;;; Sierra Script 1.0 - (do not remove this comment)
(script# 701)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	travrg 0
)

(instance travrg of Rgn
	(properties)
	
	(method (init)
		(Load rsVIEW 51)
		(Load rsSOUND 33)
		(self keep: 0)
		(if global594 (= global175 6))
		(super init:)
	)
	
	(method (doit &tmp [temp0 50])
		(if global219 (-- global220) (-- global175))
		(if (== global175 15) (proc255_0 701 0))
		(if (and (== global175 1) (!= gGNorth 18))
			(= global175 0)
			(if (== gGNorth 14)
				(self setScript: Attack1)
			else
				(self setScript: Attack2)
			)
		)
		(if
		(and (== global220 1) global209 (not global178))
			(cond 
				((== global209 2) (= global220 180))
				((== global209 3) (= global220 90))
				(else (= global220 4))
			)
			(= global161 (+ global161 global165))
			(= gGEgoY_5 (+ gGEgoY_5 global166))
			(if
			(and (== global161 global163) (== gGEgoY_5 global164))
				(= global220 0)
				(= global167 1)
			else
				(if (== global161 12)
					(= global214 (* global161 gGEgoY_5))
				else
					(= global214 (+ (* (- gGEgoY_5 1) 12) global161))
				)
				(if (> global163 global161) (= global165 1))
				(if (< global163 global161) (= global165 -1))
				(if (== global163 global161) (= global165 0))
				(if (> global164 gGEgoY_5) (= global166 1))
				(if (< global164 gGEgoY_5) (= global166 -1))
				(if (== global164 gGEgoY_5) (= global166 0))
			)
		)
		(super doit:)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if
		(or (pEvent claimed?) (!= (pEvent type?) evSAID))
			(return)
		)
	)
)

(instance Attack1 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global594 2)
					(self changeState: 4)
				else
					(ShakeScreen 5 3)
					(= global594 1)
					(if
						(or
							(not (-- global174))
							(== global205 1)
							(== global205 0)
						)
						(client setScript: BlowUp)
					)
					(zipShip
						posn: 128 69
						setLoop: 2
						cel: 0
						setPri: 6
						illegalBits: 0
						init:
						cycleSpeed: 0
						setCycle: End self
					)
				)
			)
			(1
				(zipShip cel: 0 setCycle: End self)
			)
			(2
				(zipShip cel: 0 setCycle: End self)
			)
			(3
				(zipShip
					cel: 0
					setLoop: 3
					posn: 142 79
					setCycle: End self
				)
			)
			(4
				(= global594 2)
				(= seconds 4)
			)
			(5
				(if
				(or (== global594 2) (not (gCast contains: zipShip)))
					(zipShip init:)
				)
				(zipShip
					cel: 0
					setLoop: 0
					posn: 185 72
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(6
				(zipShip
					cel: 0
					setLoop: 1
					posn: 195 80
					setCycle: End self
				)
			)
			(7
				(zipShip cel: 0 setCycle: End self)
			)
			(8
				(zipShip setLoop: 4 cel: 0 setCycle: End self)
			)
			(9
				(zipShip dispose:)
				(proc0_10)
				(ShakeScreen 5 3)
				(if
					(or
						(not (-- global174))
						(== global205 2)
						(== global205 0)
					)
					(client setScript: BlowUp)
				)
				(= global594 0)
				(= global175 10)
			)
		)
	)
)

(instance Attack2 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global594 2)
					(self changeState: 1)
				else
					(ShakeScreen 5 3)
					(= global594 1)
					(if
						(or
							(not (-- global174))
							(== global205 1)
							(== global205 0)
						)
						(global2 setScript: BlowUp)
					)
					(= cycles 1)
				)
			)
			(1
				(= global594 2)
				(= seconds 6)
			)
			(2
				(ShakeScreen 5 3)
				(if
					(or
						(not (-- global174))
						(== global205 2)
						(== global205 0)
					)
					(global2 setScript: BlowUp)
				)
				(= global175 10)
				(= global594 0)
				(global2 setScript: 0)
			)
		)
	)
)

(instance BlowUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ShakeScreen 20 3)
				(gCast eachElementDo: #dispose)
				(proc0_12)
				(global2 drawPic: 121)
				(if (not global174)
					(proc255_0 701 1)
				else
					(proc255_0 701 2)
				)
				(proc0_17 0 0 4 5)
			)
		)
	)
)

(instance zipShip of Act
	(properties)
	
	(method (init)
		(super init:)
		(self view: 51 ignoreActors: 1 setPri: 6 illegalBits: 0)
	)
)

(instance boom of Sound
	(properties
		number 33
		priority 2
	)
)
