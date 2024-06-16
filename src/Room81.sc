;;; Sierra Script 1.0 - (do not remove this comment)
(script# 81)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	Room81 0
)

(local
	local0
)
(instance door of Act
	(properties)
)

(instance guard of Act
	(properties)
)

(instance guard2 of Act
	(properties)
)

(instance guard3 of Act
	(properties)
)

(instance guard4 of Act
	(properties)
)

(instance Room81 of Rm
	(properties
		picture 81
	)
	
	(method (init)
		(super init:)
		(door
			view: 135
			setLoop: 0
			setCel: 0
			posn: 266 116
			setPri: 4
			init:
		)
		(guard
			view: 135
			loop: 2
			cel: 0
			posn: 254 117
			setPri: 3
			init:
		)
		(if global129
			(guard4
				view: 135
				setPri: 8
				setLoop: 2
				posn: 297 121
				init:
				stopUpd:
			)
			(guard
				view: 135
				setPri: 8
				setLoop: 2
				posn: 238 122
				stopUpd:
			)
			(door view: 777)
			(global2 setScript: Actions)
			(Actions state: 7)
			(Actions seconds: 12)
		else
			(global2 setScript: Actions)
		)
		(gLongSong number: 86 loop: -1 play:)
	)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(if (and (== global105 1) (== global120 1))
			(-- global121)
		)
		(if
			(and
				(== global105 1)
				(== global120 1)
				(<= global121 0)
			)
			(global2 drawPic: 81 8)
			(proc255_0 81 0)
			(= global105 0)
			(= global120 2)
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
								(proc255_0 81 1)
							)
							((Said '/guard,man,flunky') (proc255_0 81 2))
							((Said '/sign,soft,dog,scumsoft') (proc255_0 81 3))
							((Said '/door,entrance')
								(if (< (door y?) 142)
									(proc255_0 81 4)
								else
									(proc255_0 81 5)
								)
							)
						)
					)
					(
						(or
							(Said 'turn<on/belt')
							(Said 'switch<on/belt')
							(Said 'activate/belt')
							(Said 'use/belt')
							(Said 'press/button')
						)
						(cond 
							((not (gEgo has: 16)) (proc255_0 81 6))
							((!= global126 1) (proc255_0 81 7))
							((== global120 2) (proc255_0 81 8))
							((== global120 1) (proc255_0 81 9))
							(else
								(= global105 1)
								(= global120 1)
								(global2 drawPic: 82 8)
								(proc0_10)
								(proc255_0 81 10)
								(= global121 350)
							)
						)
					)
					(
					(or (Said 'turn<off/belt') (Said 'deactivate/belt'))
						(cond 
							((not (gEgo has: 16)) (proc0_9))
							((not global126) (proc255_0 81 11))
							((!= global105 1) (proc255_0 81 12))
							(else
								(proc255_0 81 13)
								(= global105 0)
								(= global120 0)
								(global2 drawPic: 81 8)
							)
						)
					)
					(
						(or
							(Said 'enter/soft,scumsoft,dog,sign,building')
							(Said 'go<in/soft,scumsoft,dog,sign,building')
							(Said 'go<to/soft,scumsoft,dog,sign,building')
							(Said 'enter/door')
						)
						(global2 newRoom: 85)
					)
					((Said 'disembark,disembark/')
						(switch (= local0 (proc255_0 81 14 81 {Ship} 1 81 {ScumSoft} 2))
							(1 (global2 newRoom: 80))
							(2 (global2 newRoom: 85))
						)
					)
				)
			else
				0
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(gLongSong fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance Actions of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 1))
			(1
				(proc255_0 81 15)
				(= global129 1)
				(door
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 266 142 self
				)
			)
			(2
				(guard
					setLoop: 1
					setCycle: Walk
					setStep: 2 2
					setPri: 8
					setMotion: MoveTo 238 122 self
				)
			)
			(3
				(guard setLoop: 2)
				(guard2
					view: 135
					setLoop: 4
					setPri: 3
					posn: 249 133
					setCycle: Walk
					ignoreActors:
					setMotion: MoveTo 269 117 self
					init:
				)
			)
			(4
				(guard3
					view: 135
					setLoop: 4
					setCycle: Walk
					setPri: 3
					posn: 249 133
					setStep: 2 2
					setMotion: MoveTo 269 117 self
					init:
				)
				(guard2 setPri: 8 setPri: 9 setMotion: MoveTo 323 150)
			)
			(5
				(guard4
					view: 135
					setLoop: 4
					setCycle: Walk
					setPri: 3
					posn: 249 133
					setStep: 2 2
					setMotion: MoveTo 269 117 self
					init:
				)
				(guard3 setPri: 8 setMotion: MoveTo 323 150)
			)
			(6
				(guard4 setPri: 8 setMotion: MoveTo 297 121 self)
			)
			(7
				(guard4 setLoop: 2)
				(proc0_10)
				(proc255_0 81 16)
				(= seconds 12)
			)
			(8
				(switch
					(= local0
						(proc255_0
							81
							17
							81
							{Stay Here}
							1
							81
							{Return to Ship}
							2
							81
							{Enter ScumSoft}
							3
						)
					)
					(1 (= seconds 20) (-- state))
					(2 (global2 newRoom: 80))
					(3 (global2 newRoom: 85))
					(else 
						(= seconds 20)
						(-- state)
					)
				)
			)
		)
	)
)
