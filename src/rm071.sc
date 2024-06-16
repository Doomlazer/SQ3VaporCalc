;;; Sierra Script 1.0 - (do not remove this comment)
(script# 71)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Game)
(use TheMenuBar)

(public
	rm071 0
)

(instance rm071 of Rm
	(properties
		picture 71
		north 72
		west 70
	)
	
	(method (init &tmp [temp0 50])
		(proc0_3)
		(self setRegions: 600)
		(super init:)
		(switch gNorth
			(70
				(gEgo
					init:
					posn:
						2
						(cond 
							((== (gEgo y?) 74) 75)
							((and (> (gEgo y?) 87) (< (gEgo y?) 99)) 99)
							((and (> (gEgo y?) 118) (< (gEgo y?) 137)) 137)
							(else (gEgo y?))
						)
				)
			)
			(72
				(gEgo
					posn:
						(cond 
							((< (gEgo x?) 87) 88)
							((> (gEgo x?) 156) 155)
							(else (gEgo x?))
						)
						(+ (global2 horizon?) 10)
					init:
				)
				(gLongSong number: 71 loop: -1 priority: 0 play:)
			)
		)
		(TheMenuBar draw:)
		(SL enable:)
	)
	
	(method (doit &tmp gEgoOnControl)
		(super doit:)
		(if (== (global2 script?) 0)
			(cond 
				((== (= gEgoOnControl (gEgo onControl:)) 3)
					(gEgo
						setPri: 14
						posn: (gEgo x?) (+ (gEgo y?) 2)
						illegalBits: 0
					)
					(= global180 1)
				)
				((== gEgoOnControl 5)
					(gEgo
						setPri: 9
						posn: (gEgo x?) (gEgo y?)
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
		(if (Said 'look[/area,around]')
			(if (== gNorth 72)
				(proc255_0 71 0)
			else
				(proc255_0 71 1)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (not script)
			(if global256 (++ global593))
			(super newRoom: newRoomNumber)
		)
	)
)
