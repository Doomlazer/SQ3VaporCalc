;;; Sierra Script 1.0 - (do not remove this comment)
(script# 42)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room42 0
)

(local
	newAct
)
(instance lightning of Prop
	(properties)
)

(instance thunder of Sound
	(properties)
)

(instance Room42 of Rm
	(properties
		picture 42
	)
	
	(method (init)
		(= east 43)
		(= south 46)
		(= west 41)
		(= north 54)
		(= horizon 94)
		(= global109 0)
		(= global591 0)
		(= global104 0)
		(super init:)
		(gEgo init:)
		(Load rsSOUND 31)
		(Load rsSOUND 32)
		(lightning
			view: 69
			loop: 6
			cel: 0
			posn: 123 59
			setScript: flash
			init:
		)
		(switch gNorth
			(41
				(proc0_1)
				(= global104 0)
				(if (< (gEgo y?) (+ horizon 2))
					(gEgo posn: 1 (+ horizon 2))
				else
					(gEgo posn: 1 (gEgo y?))
				)
			)
			(46
				(proc0_1)
				(= global104 0)
				(gEgo view: 0 posn: (gEgo x?) 188)
			)
			(43
				(proc0_1)
				(gEgo view: 0 posn: 318 (gEgo y?))
			)
			(420
				(proc0_1)
				(gLongSong number: 22 priority: 0 loop: -1 play:)
				(gEgo view: 0 loop: 1 posn: 266 107)
			)
			(54
				(gEgo posn: (gEgo x?) (+ horizon 2))
			)
			(421
				(global2 setScript: festerOut)
			)
			(else 
				(gEgo posn: 188 160 view: 0)
			)
		)
		(gEgo init:)
		(self setRegions: 501)
		(switch global110
			(1
				(if (== (Random 1 4) 3)
					(Load rsVIEW 106)
					((= gNewAct (Act new:)) posn: 1000 1000 init:)
					(= gSeconds (Random 2 12))
				)
			)
			(2
				((= gNewAct (Act new:)) posn: 1000 1000 init:)
				(= gSeconds 3)
			)
		)
		(cond 
			((gCast contains: gNewAct)
				(gNewAct
					view: 106
					setCycle: Walk
					observeControl: 2
					posn: 1000 1000
					init:
				)
				(switch gNorth
					(east (gNewAct posn: 359 167))
					(west (gNewAct posn: -40 143))
					(south (gNewAct posn: 160 249))
					(north
						(gNewAct posn: 160 (+ horizon 2))
					)
				)
				(= global110 1)
				((ScriptID 501 0) notify: 1)
			)
			((== (global2 script?) 0) ((ScriptID 501 0) notify: 4))
		)
	)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(if (& (gEgo onControl: 1) $0040)
			(global2 newRoom: 420)
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
								(proc255_0 42 0)
							)
							((Said '/feet,toe,leg') (proc255_0 42 1))
							((Said '/entrance,cavity') (proc255_0 42 2))
							((Said '/door,door') (proc255_0 42 3))
							((Said '/mog,animal') (proc255_0 42 4))
							((Said '/sign') (proc255_0 42 5))
						)
					)
					((Said 'get,drag,beat/sign,mog') (proc255_0 42 6))
					((Said 'read/sign')
						(cond 
							((& (gEgo onControl: 0) $2000)
								(if (or (== (gEgo loop?) 0) (== (gEgo loop?) 2))
									(proc255_0 42 7 30 1 67 -1 100)
								else
									(proc255_0 42 8)
								)
							)
							((& (gEgo onControl: 0) $1000)
								(if (!= (gEgo loop?) 3)
									(proc255_0 42 8)
								else
									(proc255_0 42 9 67 -1 100)
								)
							)
							(else (proc255_0 42 10))
						)
					)
				)
			else
				0
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 420) (gLongSong fade:))
		(if
			(and
				(gCast contains: gNewAct)
				(< (gEgo distanceTo: gNewAct) 120)
			)
			(= global110 2)
		)
		(if (not global155) (super newRoom: newRoomNumber))
	)
)

(instance flash of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds (Random 8 30)))
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
			(4 (= state -1))
		)
	)
)

(instance festerOut of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_3)
				(gLongSong number: 22 priority: 0 loop: -1 play:)
				(= newAct (Act new:))
				(newAct
					view: 67
					setLoop: 0
					setCycle: Walk
					posn: 244 128
					setMotion: MoveTo 329 175 self
					init:
				)
				(proc0_1)
				(gEgo view: 0 loop: 1 posn: 266 107 init:)
			)
			(1 (newAct dispose:))
		)
	)
)
