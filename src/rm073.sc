;;; Sierra Script 1.0 - (do not remove this comment)
(script# 73)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Obj)

(public
	rm073 0
)

(instance rm073 of Rm
	(properties
		picture 73
		east 74
		south 74
	)
	
	(method (init &tmp [temp0 50])
		(User canInput: 1 canControl: 1)
		(self setRegions: 600)
		(Load rsVIEW 68)
		(super init:)
		(gEgo
			view: 68
			setStep: 2 2
			illegalBits: -32768
			setLoop: -1
			init:
		)
		(if global255
			(self setScript: WalkIn)
		else
			(gEgo posn: 316 (gEgo y?))
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'look>')
				(cond 
					((Said '[/area,around]') (proc255_0 73 0))
					((Said '/lava') (proc255_0 73 1))
					((Said '/device,building,generator')
						(cond 
							((not global256) (if global170 (proc255_0 73 2) else (proc255_0 73 3)))
							(global170 (proc255_0 73 4))
							(else (proc255_0 73 5))
						)
					)
					((Said '/beam')
						(if (not global256)
							(if global170 (proc255_0 73 6) else (proc255_0 73 7))
						else
							(proc255_0 73 8)
						)
					)
				)
			)
			((Said 'climb') (proc255_0 73 9))
		)
	)
	
	(method (newRoom newRoomNumber &tmp [temp0 50])
		(if (not script)
			(if (> (gEgo y?) 140)
				(= global255 1)
			else
				(= global255 0)
			)
			(if global256 (++ global593))
			(super newRoom: newRoomNumber)
		)
	)
)

(instance WalkIn of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					posn: 195 197
					loop: 3
					setPri: -1
					setMotion: MoveTo 195 187 self
				)
			)
			(1
				(proc0_3)
				(client setScript: 0)
			)
		)
	)
)
