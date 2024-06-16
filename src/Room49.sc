;;; Sierra Script 1.0 - (do not remove this comment)
(script# 49)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room49 0
)

(local
	local0
	newSound
)
(instance Room49 of Rm
	(properties
		picture 49
	)
	
	(method (init)
		(= east 50)
		(= west 52)
		(= north 45)
		(= south 53)
		(= horizon 72)
		(= global109 0)
		(Load rsSOUND 31)
		(Load rsSOUND 32)
		(Load rsVIEW 63)
		(super init:)
		(lightning init:)
		(gEgo init:)
		(proc0_1)
		(= global104 0)
		(switch gNorth
			(50
				(cond 
					((< (gEgo y?) 94) (gEgo view: 0 posn: 318 (gEgo y?)))
					((== global104 0) (gEgo view: 63 posn: 317 (gEgo y?)))
				)
			)
			(45
				(proc0_1)
				(gEgo view: 63 posn: (gEgo x?) (+ horizon 2))
			)
			(52
				(switch global104
					(0
						(gEgo posn: 1 (gEgo y?) view: 63 setPri: -1)
					)
					(1
						(proc0_1)
						(gEgo posn: 1 80 view: 0)
					)
					(2
						(proc0_1)
						(gEgo posn: 1 80 view: 0)
					)
				)
			)
			(53
				(proc0_1)
				(proc0_3)
				(gEgo view: 0 posn: (gEgo x?) 188)
			)
			(40
				(proc0_1)
				(= global100 0)
				(proc0_3)
				(gEgo view: 63 posn: 184 174 loop: 2 init:)
			)
			(14
				(gEgo view: 63)
				(global2 setScript: Actions)
				(gLongSong
					owner: -1
					number: 22
					priority: 1
					loop: -1
					play:
				)
				(= global100 1)
			)
			(else 
				(gEgo view: 63 posn: 160 187 init:)
			)
		)
		(cond 
			(
				(and
					(!= global155 1)
					(!= gNorth 45)
					(gEgo inRect: -5 0 324 94)
					(!= (global2 script?) termCatch)
				)
				(gEgo view: 0)
			)
			((!= (global2 script?) termCatch) (gEgo view: 63))
		)
		(self setRegions: 501)
	)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(if
			(and
				(or (== global110 1) (== global110 2))
				(not (gCast contains: gNewAct))
				(& (gEgo onControl: 1) $0004)
			)
			(global2 setScript: termCatch)
		)
		(if
			(and
				(& (gEgo onControl:) $4000)
				(== script 0)
				(not (gCast contains: gNewAct))
			)
			(global2 newRoom: 14)
		)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return 1))
		(return
			(if (== (pEvent type?) evSAID)
				(cond 
					((Said 'look>')
						(cond 
							(
								(or
									(Said '/area')
									(Said '/around')
									(Said '[<around][/!*]')
								)
								(proc255_0 49 0)
							)
							((Said '/craft,aluminum,aluminum') (proc255_0 49 1))
						)
					)
					((Said 'enter/craft') (proc255_0 49 2))
				)
			else
				0
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(proc0_1)
		(DisposeScript 988)
		(if (== newRoomNumber 14) (gLongSong fade:))
		(if (or (not global155) (== newRoomNumber 40))
			(super newRoom: newRoomNumber)
		)
	)
)

(instance Actions of Script
	(properties)
	
	(method (doit)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo posn: 157 143 setMotion: MoveTo 184 174 self)
			)
			(1
				(proc255_0 49 3)
				(proc0_10)
				(if (== global118 0)
					(= global118 1)
					(proc255_0 49 4 91)
					(= seconds 5)
				else
					(proc0_3)
				)
			)
			(2
				(proc0_12)
				(global2 newRoom: 40)
			)
		)
	)
)

(instance flash of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 10 20)))
			(1
				(lightning cel: 255 setCycle: End self)
			)
			(2
				(lightning cel: 0)
				(= seconds (Random 2 5))
			)
			(3
				(thunder priority: 2 number: (Random 31 32) play: self)
			)
			(4 (self init:))
		)
	)
)

(instance termCatch of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(= gNewAct (Act new:))
				(gNewAct
					view: 106
					setPri: (gEgo priority?)
					observeControl: 16384
					setLoop: 8
					setCycle: Fwd
					init:
				)
				(gNewAct posn: (gEgo x?) (gEgo y?))
				((= newSound (Sound new:))
					number: 97
					loop: -1
					priority: 99
					play:
				)
				(gEgo illegalBits: 0 ignoreActors: hide:)
				(= seconds 7)
			)
			(1
				(newSound stop:)
				(proc0_17 901 0 14 16)
			)
		)
	)
)

(instance lightning of Prop
	(properties
		y 54
		x 48
		view 69
		loop 4
	)
	
	(method (init)
		(super init:)
		(self setScript: flash)
	)
)

(instance thunder of Sound
	(properties)
)
