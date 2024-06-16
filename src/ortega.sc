;;; Sierra Script 1.0 - (do not remove this comment)
(script# 600)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	ortega 0
)

(local
	local0
)
(instance ortega of Rgn
	(properties)
	
	(method (init)
		(self keep: 0)
		(super init:)
		(Load rsVIEW 94)
		(Load rsVIEW 89)
		(Load rsSOUND 45)
		(Load rsSOUND 78)
	)
	
	(method (doit)
		(super doit:)
		(if global180
			(= global180 0)
			(global2 setScript: FallDown)
		)
		(if (and global219 (> global171 1)) (-- global171))
		(if
			(and
				(== global171 1)
				(!= gGNorth 62)
				(== (proc0_15 gEgo 15) 1)
				(== (global2 script?) 0)
			)
			(global2 setScript: FryToDeath)
		)
		(if (and global256 (not (-- global257)))
			(boom play:)
			(ShakeScreen 20 3)
			(= global257 (Random 10 600))
			(if (not global184) (proc255_0 600 0) (= global184 1))
		)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if
		(or (pEvent claimed?) (!= (pEvent type?) evSAID))
			(return)
		)
		(cond 
			((Said 'look>')
				(cond 
					((Said '[/area,around,moon,dirt,ortega]')
						(if (== gGNorth 70)
							(if global253 (proc255_0 600 1) else (proc255_0 600 2))
						else
							(proc255_0 600 3)
						)
					)
					((Said '/volcano') (proc255_0 600 4))
					((Said '/lava') (proc255_0 600 5))
					((Said '/rock,boulder') (proc255_0 600 6))
					((Said '/lake') (proc255_0 600 7))
					((Said '/air') (proc255_0 600 8))
					((Said '/ledge,cliff,edge') (proc255_0 600 9))
					((Said '/crack') (proc255_0 600 10))
					((Said '/cavity,canyon') (proc255_0 600 11))
					((Said '/partition')
						(if
						(or (== gGNorth 73) (== gGNorth 74) (== gGNorth 75))
							(proc255_0 600 12)
						else
							(proc255_0 600 13)
						)
					)
					((Said '/craft')
						(switch gGNorth
							(62 (proc255_0 600 14))
							(67 (proc255_0 600 15))
							(70
								(if global253
									(proc255_0 600 16)
								else
									(proc255_0 600 17)
								)
							)
							(else  (proc255_0 600 16))
						)
					)
				)
			)
			((Said 'open/door') (proc255_0 600 18))
			((Said 'jump<off/cliff') (proc255_0 600 19))
			((Said 'get/ladder')
				(if (or (== gGNorth 74) (== gGNorth 75))
					(proc255_0 600 20)
				else
					(proc255_0 600 21)
				)
			)
			((Said 'get/rock') (proc255_0 600 22))
			((Said 'get/dirt') (proc255_0 600 23))
			((Said 'use/pole') (if (!= gGNorth 66) (proc0_8)))
			((Said '(turn<on),press,use/detonator') (if (gEgo has: 10) (proc255_0 600 24) else (proc0_9)))
			((Said 'wear/panties')
				(if (gEgo has: 5)
					(if global182
						(proc255_0 600 25)
					else
						(proc255_0 600 26)
					)
				else
					(proc255_0 600 27)
				)
			)
			((Said 'remove/panties')
				(if global182
					(proc255_0 600 28)
				else
					(proc255_0 600 29)
				)
			)
			((and (Said 'climb') (< gGNorth 73)) (proc255_0 600 30))
		)
	)
)

(instance FryToDeath of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= global159 1)
				(= global171 0)
				(proc255_0 600 31)
				(gEgo
					view: 89
					setLoop: 0
					setCel: 0
					setMotion: 0
					setCycle: End self
				)
			)
			(1
				(gEgo setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(3 (= cycles 10))
			(4
				(proc255_0 600 32)
				(proc0_17 0 0 8 11)
				(= global159 0)
				(proc0_3)
			)
		)
	)
)

(instance FallDown of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if (== (fallSound prevSignal?) -1) (= local0 1))
		(if (or local0 (== (fallSound state?) 0))
			(= local0 0)
			(self changeState: 1)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(fallSound play:)
				(gEgo setLoop: setCel: 0 setStep: 6 12 setCycle: 0)
				(proc0_10)
				(gEgo setMotion: MoveTo (gEgo x?) 229)
				(ohnoScript changeState: 0)
			)
			(1 (proc0_17 0 0 1 2))
		)
	)
)

(instance ohnoScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(ohno init: setCycle: End self)
			)
			(1 (ohno dispose:))
		)
	)
)

(instance ohno of Prop
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 94
			setLoop: 0
			setCel: 0
			cycleSpeed: 1
			setPri: (gEgo priority?)
			posn: (gEgo x?) (- (gEgo y?) 40)
			ignoreActors: 1
		)
	)
)

(instance fallSound of Sound
	(properties
		number 45
		priority 3
	)
)

(instance boom of Sound
	(properties
		number 78
		priority 1
	)
)
