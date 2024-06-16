;;; Sierra Script 1.0 - (do not remove this comment)
(script# 74)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use User)
(use Obj)

(public
	rm074 0
)

(local
	local0
	local1
)
(instance rm074 of Rm
	(properties
		picture 74
		south 72
		west 73
	)
	
	(method (init &tmp [temp0 50])
		(User canInput: 1 canControl: 1)
		(self setRegions: 600)
		(Load rsVIEW 68)
		(Load rsVIEW 97)
		(super init:)
		(switch gNorth
			(72
				(gEgo init: illegalBits: 16384 setPri: 14 posn: 225 187)
			)
			(73
				(if global255
					(global2 setScript: UpStairs)
				else
					(gEgo posn: 2 (gEgo y?) init:)
				)
			)
			(75
				(if global256
					(gLongSong number: 71 loop: -1 priority: 0 play:)
				else
					(gLongSong number: 51 loop: -1 priority: 0 play:)
				)
				(global2 setScript: DownLadder)
			)
		)
	)
	
	(method (doit &tmp temp0)
		(super doit:)
		(if local0 (global2 newRoom: 73))
		(if local1 (global2 newRoom: 75))
		(if (== (gEgo view?) 68)
			(if (> (gEgo y?) 174)
				(gEgo setPri: 13)
			else
				(gEgo setPri: -1)
			)
		)
		(if
			(and
				(not (global2 script?))
				(== (gEgo onControl:) 5)
				(!= (gEgo view?) 68)
			)
			(self setScript: DownStairs)
		)
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
					((Said '[/area,around]')
						(if (== (gEgo view?) 0)
							(proc255_0 74 0)
						else
							(proc255_0 74 1)
						)
					)
					((Said '/lava') (proc255_0 74 2))
					((Said '/ladder') (proc255_0 74 3))
					((Said '/stair') (proc255_0 74 4))
					((Said '/banister') (proc255_0 74 5))
					((Said '/device,building,generator')
						(cond 
							((not global256) (if global170 (proc255_0 74 6) else (proc255_0 74 7)))
							(global170 (proc255_0 74 8))
							(else (proc255_0 74 9))
						)
					)
					((Said '/beam')
						(if (not global256)
							(if global170 (proc255_0 74 10) else (proc255_0 74 11))
						else
							(proc255_0 74 12)
						)
					)
					((Said '/pedestal') (proc255_0 74 13))
				)
			)
			((Said 'up,climb,(climb[<up])[/ladder]')
				(if (gEgo inRect: 146 108 163 112)
					(global2 setScript: UpLadder)
				else
					(proc255_0 74 14)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (not script)
			(if local0 (= global255 1) else (= global255 0))
			(if global256 (++ global593))
			(super newRoom: newRoomNumber)
		)
	)
)

(instance DownStairs of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					setLoop: 1
					illegalBits: 0
					setMotion: MoveTo 88 216 self
				)
			)
			(1
				(= local0 1)
				(proc0_3)
				(global2 setScript: 0)
			)
		)
	)
)

(instance UpStairs of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					view: 0
					posn: 88 216
					setLoop: 0
					setPri: 14
					setStep: 3 2
					illegalBits: 0
					init:
				)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 138 175 self)
			)
			(2
				(gEgo setLoop: -1 illegalBits: 16384)
				(proc0_3)
				(global2 setScript: 0)
			)
		)
	)
)

(instance UpLadder of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo illegalBits: 0)
				(proc0_10)
				(gEgo
					posn: 154 107
					view: 97
					setLoop: 0
					setMotion: MoveTo 154 65 self
				)
			)
			(1
				(gEgo posn: 153 65 setMotion: MoveTo 153 31 self)
			)
			(2
				(gEgo posn: 152 31 setMotion: MoveTo 152 13 self)
			)
			(3
				(gEgo posn: 151 13 setMotion: MoveTo 151 -2 self)
			)
			(4
				(proc0_3)
				(= local1 1)
				(global2 setScript: 0)
			)
		)
	)
)

(instance DownLadder of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					init:
					posn: 151 -2
					view: 97
					illegalBits: 0
					setLoop: 0
					setMotion: MoveTo 151 13 self
				)
			)
			(1
				(gEgo posn: 152 13 setMotion: MoveTo 152 31 self)
			)
			(2
				(gEgo posn: 153 31 setMotion: MoveTo 153 65 self)
			)
			(3
				(gEgo posn: 154 65 setMotion: MoveTo 154 109 self)
			)
			(4
				(gEgo
					view: 68
					setLoop: -1
					setStep: 2 2
					illegalBits: -32768
				)
				(= cycles 2)
			)
			(5
				(gEgo loop: 3)
				(proc0_3)
				(global2 setScript: 0)
			)
		)
	)
)
