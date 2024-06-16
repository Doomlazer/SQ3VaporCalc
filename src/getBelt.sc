;;; Sierra Script 1.0 - (do not remove this comment)
(script# 520)
(include sci.sh)
(use Main)
(use Avoid)
(use Cycle)
(use Feature)
(use Obj)

(public
	getBelt 0
)

(local
	newProp
)
(instance getBelt of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					setAvoider: Avoid
					setMotion: MoveTo (- (gNewView x?) 40) 122 self
				)
			)
			(1
				(gEgo
					view: 122
					setLoop: 0
					cel: 255
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 1 setCel: 0)
				(= newProp (Prop new:))
				(newProp
					view: 122
					setLoop: 2
					cel: 255
					posn: (+ (gEgo x?) 5) (- (gEgo y?) 2)
					setPri: 7
					cycleSpeed: 3
					setCycle: End self
					init:
				)
			)
			(3
				(gNewView_2 dispose:)
				(= seconds 3)
			)
			(4
				(newProp dispose:)
				(gEgo loop: 0 setCel: 255 setCycle: Beg self)
				(gEgo get: 16)
				(gGame changeScore: 35)
			)
			(5
				(gEgo
					view: 0
					setLoop: -1
					setCel: -1
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 179 110 self
				)
			)
			(6
				(proc0_3)
				(gEgo loop: 2 setAvoider: 0)
				(global2 setScript: 0)
				(DisposeScript 520)
			)
		)
	)
)
