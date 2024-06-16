;;; Sierra Script 1.0 - (do not remove this comment)
(script# 62)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use TheMenuBar)
(use Obj)

(public
	rm062 0
)

(instance rm062 of Rm
	(properties
		picture 62
		south 67
		west 61
	)
	
	(method (init &tmp [temp0 50])
		(proc0_3)
		(self setRegions: 600)
		(Load rsVIEW 63)
		(super init:)
		(TheMenuBar draw:)
		(SL enable:)
		(switch gNorth
			(61
				(gEgo setStep: 4 3 view: 63 posn: 2 (gEgo y?) init:)
			)
			(67
				(gEgo setStep: 4 3 view: 63 posn: (gEgo x?) 187 init:)
			)
			(else 
				(Load rsSOUND 71)
				(self setScript: landScript)
			)
		)
	)
	
	(method (doit &tmp gEgoOnControl)
		(super doit:)
		(if (> global593 15) (self setScript: CrackUp))
		(if (== (global2 script?) 0)
			(if (== (= gEgoOnControl (gEgo onControl:)) 16385)
				(global2 newRoom: 14)
			)
			(cond 
				((== gEgoOnControl 3)
					(gEgo setPri: 7 posn: (+ (gEgo x?) 6) (gEgo y?))
					(= global180 1)
				)
				(
					(or
						(== gEgoOnControl 5)
						(== gEgoOnControl 7)
						(== gEgoOnControl 13)
					)
					(gEgo
						setPri: 5
						posn:
							(if (< (gEgo x?) 100)
								(- (gEgo x?) 6)
							else
								(+ (gEgo x?) 6)
							)
							(gEgo y?)
					)
					(= global180 1)
				)
				((== gEgoOnControl 9)
					(gEgo setPri: 3 posn: (gEgo x?) (- (gEgo y?) 6))
					(= global180 1)
				)
				(
				(or (== gEgoOnControl 17) (== gEgoOnControl 19))
					(gEgo setPri: 9 posn: (+ (gEgo x?) 12) (gEgo y?))
					(= global180 1)
				)
				(
				(or (== gEgoOnControl 33) (== gEgoOnControl 37))
					(gEgo
						setPri: 5
						posn:
							(if (< (gEgo x?) 100)
								(- (gEgo x?) 6)
							else
								(+ (gEgo x?) 18)
							)
							(gEgo y?)
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
		(switch (pEvent type?)
			(evSAID
				(if
					(or
						(Said 'enter,go,get[<in]/craft,ramp,door')
						(Said 'climb/ramp')
					)
					(proc255_0 62 0)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (== script 0)
			(gEgo setStep: 3 2)
			(if global256 (++ global593))
			(if (> global593 15)
				(self setScript: CrackUp)
			else
				(super newRoom: newRoomNumber)
			)
		)
	)
)

(instance landScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					setStep: 4 3
					view: 63
					setLoop: 2
					posn: 164 142
					setPri: -1
					illegalBits: 0
					edgeHit: 0
					init:
				)
				(= seconds 2)
			)
			(1
				(gEgo setMotion: MoveTo 151 162 self)
			)
			(2
				(gEgo setLoop: -1 setPri: -1 illegalBits: -32768)
				(proc0_3)
				(if global182
					(proc255_0 62 1)
					(= global171 0)
				else
					(proc255_0 62 2)
					(= global171 10)
				)
				(gLongSong number: 71 loop: -1 priority: 0 play:)
				(global2 setScript: 0)
			)
		)
	)
)

(instance CrackUp of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global593 0)
				(proc0_2)
				(ShakeScreen 30 3)
				(gEgo dispose:)
				(proc0_10)
				(proc255_0 62 3)
				(proc0_17 0 0 1 2)
			)
		)
	)
)
