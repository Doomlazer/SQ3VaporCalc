;;; Sierra Script 1.0 - (do not remove this comment)
(script# 2)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Timer)
(use Sound)
(use Jump)
(use Cycle)
(use Game)
(use TheMenuBar)
(use Feature)
(use Obj)

(public
	rm002 0
)

(local
	newAct
	gEgoX
	gEgoY
	local3
	local4
	local5
)
(instance rm002 of Rm
	(properties
		picture 2
		horizon 70
		east 5
		south 3
	)
	
	(method (init &tmp [temp0 50])
		(if
			(or
				(== gNorth 777)
				(== gNorth 900)
				(== gNorth 1)
				(== gNorth 155)
				(== (GameIsRestarting) 1)
			)
			(gLongSong stop:)
			(= local4 1)
		)
		(= global193 0)
		(= global17 0)
		(if (!= gNorth 12) (self setLocales: 700))
		(Load rsVIEW 12)
		(Load rsVIEW 0)
		(Load rsVIEW 6)
		(Load rsSOUND 11)
		(Load rsSOUND 76)
		(if (== gGGNorth gGNorth)
			(Load rsVIEW 36)
			(motivator init:)
		)
		(if (== gNorth 12)
			(proc0_2)
			(Load rsVIEW 258)
			(self setScript: grabScript)
		else
			(Load rsVIEW 0)
			(TheMenuBar state: 1 draw:)
			(SL enable:)
			(if local4
				(Load rsSCRIPT 991)
				(= local3 991)
				(Load rsVIEW 11)
				(Load rsSOUND 4)
				(Load rsSOUND 5)
				(Load rsSOUND 56)
				(gEgo
					view: 11
					loop: 0
					cel: 0
					setPri: 9
					ignoreActors: 1
					illegalBits: 0
					posn: 141 111
					get: 0
				)
				(proc0_2)
				(self setScript: doorScript)
			)
			(if (and global200 (== gNorth 900) (not local4))
				(proc0_3)
				(gEgo
					view: 0
					setLoop: -1
					loop: 2
					cel: 0
					ignoreActors: 1
					illegalBits: -32768
					setStep: 3 2
					posn: 142 141
					get: 0
				)
				(= gEgoX (gEgo x?))
				(= gEgoY (gEgo y?))
				(= global159 0)
				(gLongSong number: 11 loop: -1 play:)
			)
			(if (== gNorth 3) (gEgo x: 170))
			(gEgo init:)
		)
		(door init:)
		(super init:)
	)
	
	(method (doit)
		(if (or (== (gEgo view?) 0) (== (gEgo view?) 6))
			(cond 
				(
					(or
						(== (gEgo onControl: 0) 4)
						(== (gEgo onControl: 0) 5)
					)
					(gEgo view: 6)
				)
				((== (gEgo onControl: 0) 1) (gEgo view: 0))
			)
		)
		(super doit:)
	)
	
	(method (dispose)
		(if
		(and (!= gNorth 5) (!= gNorth 12) (!= gNorth 3))
			(DisposeScript 991)
		)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(cond 
					((Said 'close/door') (proc255_0 2 0))
					((Said 'look>')
						(cond 
							((Said '<in,through/craft,chute,pane[<escape]') (proc255_0 2 1))
							((Said '/pane') (proc255_0 2 2))
							((Said '/door,door') (proc255_0 2 3))
							((Said '/nozzle') (proc255_0 2 4))
							((Said '/craft,chute[<escape]') (proc255_0 2 5))
							((Said '[<at,around,in][/area,!*]') (proc255_0 2 6))
						)
					)
					((Said 'smell[/area,air]') (proc255_0 2 7))
					((Said 'fix,open,pry/craft,chute,door[<escape]') (proc255_0 2 8))
					(
					(Said 'hoist,manipulate,press,drag/craft,chute[<escape]') (proc255_0 2 9))
					((Said 'begin/chute,craft,engine') (proc255_0 2 10))
					((Said 'break/pane,glass') (proc255_0 2 11))
					((Said 'climb/craft,chute[<escape]') (proc255_0 2 12))
					((Said 'climb') (proc255_0 2 13))
					(
						(or
							(Said 'climb,get<in,in/craft,chute[<escape]')
							(Said 'enter,board[/craft,chute[<escape]]')
						)
						(proc255_0 2 14)
					)
					((Said 'qa')
						(if (not global200) (pEvent claimed: 0) (return))
						(switch
							(= local5
								(proc255_0
									2
									15
									30
									1
									80
									{QA-O-Matic}
									81
									{Space}
									1
									81
									{Phleebhut}
									2
									81
									{Ortega}
									3
									81
									{Pestulon}
									4
									81
									{End}
									5
								)
							)
							(1
								(= global136 4)
								((gInv at: 3) moveTo: 14)
								((gInv at: 1) moveTo: 14)
								(= gGGNorth 0)
								(= gGGGGNorth 4)
								(= global203 1)
								(= global210 1)
								(= global207 1)
								(= global208 2)
								(= global206 3)
								(= global15 134)
								(gGame changeScore: 1)
								(proc0_10)
								(global2 newRoom: 14)
							)
							(2
								(= global136 4)
								((gInv at: 3) moveTo: 14)
								((gInv at: 1) moveTo: 14)
								(= gGGNorth 0)
								(= gGGGGNorth 4)
								(= global210 6)
								(= global214 39)
								(= global213 39)
								(= global161 3)
								(= gGEgoY_5 4)
								(= global163 3)
								(= global164 4)
								(proc0_10)
								(global2 newRoom: 21)
							)
							(3
								(= global136 4)
								((gInv at: 3) moveTo: 14)
								((gInv at: 1) moveTo: 14)
								(= gGGNorth 0)
								(= gGGGGNorth 4)
								(= global210 5)
								(= global214 82)
								(= global213 82)
								(= global161 10)
								(= gGEgoY_5 7)
								(= global163 10)
								(= global164 7)
								(proc0_10)
								(global2 newRoom: 21)
							)
							(4
								(= global136 4)
								((gInv at: 3) moveTo: 14)
								((gInv at: 1) moveTo: 14)
								(= gGGNorth 0)
								(= gGGGGNorth 4)
								(proc0_14 0 0)
								(= global210 8)
								(= global214 69)
								(= global213 69)
								(= global161 9)
								(= gGEgoY_5 6)
								(= global163 9)
								(= global164 6)
								(proc0_10)
								(global2 newRoom: 21)
							)
							(5
								(= global136 4)
								((gInv at: 3) moveTo: 14)
								((gInv at: 1) moveTo: 14)
								(= gGGNorth 0)
								(= gGGGGNorth 4)
								(= global210 7)
								(= global214 69)
								(= global213 69)
								(= global161 9)
								(= gGEgoY_5 6)
								(= global163 9)
								(= global164 6)
								(proc0_10)
								(global2 newRoom: 94)
							)
						)
					)
				)
			)
		)
	)
)

(instance doorScript of Script
	(properties)
	
	(method (doit)
		(if
		(and (== (self state?) 19) (== (doorSound state?) 0))
			(self cue:)
		)
		(super doit:)
	)
	
	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(gEgo stopUpd:)
				(= seconds 3)
			)
			(1
				(doorSound play:)
				(= cycles 20)
			)
			(2 (door setCycle: End self))
			(3
				(door stopUpd:)
				(= cycles 8)
			)
			(4
				(gEgo setPri: 10 cycleSpeed: 1 setCycle: End self)
			)
			(5 (= cycles 7))
			(6
				(gEgo loop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(7 (= cycles 7))
			(8 (gEgo setCycle: End self))
			(9 (= cycles 10))
			(10
				(gEgo loop: 2 cel: 0 setCycle: 0)
				(= cycles 10)
			)
			(11
				(gEgo loop: 2 cel: 0 setCycle: CT 1 1 self)
			)
			(12
				(gEgo
					cycleSpeed: 0
					setStep: -1 10
					setMotion: JumpTo 142 141 self
				)
			)
			(13
				(gEgo setCycle: End self)
				(thump play:)
			)
			(14 (= cycles 7))
			(15
				(gEgo setCel: (- (gEgo cel?) 1))
				(= cycles 5)
			)
			(16
				(gEgo
					view: 0
					loop: 2
					cel: 0
					illegalBits: -32768
					setStep: -1 2
					setCycle: Walk
					setPri: -1
				)
				(= gEgoX (gEgo x?))
				(= gEgoY (gEgo y?))
				(= global159 0)
				(= cycles 10)
			)
			(17
				(proc255_0 2 16 67 -1 20 70 280)
				(door setPri: 9 setCycle: Beg self)
				(= cycles 2)
			)
			(18 (doorSound number: 5 play:))
			(19 (door stopUpd:))
			(20
				(door setLoop: 1 forceUpd:)
				(= seconds 2)
			)
			(21
				(proc0_3)
				(gLongSong number: 11 loop: -1 play:)
			)
		)
	)
)

(instance grabScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((= newAct (Act new:))
					view: 258
					setLoop: (if (== gGGGGNorth 3) 2 else 0)
					setPri: (if gGGGNorth 13 else 10)
					setStep: 1 2
					x: (if gGGGNorth 166 else 72)
					y: -16
					illegalBits: 0
					ignoreHorizon: 1
					ignoreActors: 1
					init:
					setCycle: Fwd
					setMotion: MoveTo (if gGGGNorth 166 else 72) 153 self
				)
			)
			(1
				(if (== gGGGNorth 0) (newAct setPri: 13))
				(Timer set: self 2)
			)
			(2
				(if (== gGGGNorth 0) (newAct setPri: 10))
				(cond 
					((== gGGGGNorth 3)
						(= global148 4)
						(= gGGGGNorth gGGGNorth)
						(motivator init:)
						(= gGGNorth gGNorth)
						(gLongSong number: 76 loop: 1 play:)
						(gGame changeScore: -15)
						(proc0_10)
						(proc255_0 2 17)
					)
					(
					(and (== gGGNorth gGNorth) (== gGGGGNorth gGGGNorth))
						(gLongSong number: 76 loop: 1 play:)
						(gGame changeScore: 15)
						(newAct setLoop: 2)
						(motivator hide:)
						(= gGGNorth 0)
						(= gGGGGNorth 3)
						(= global148 5)
						(proc0_10)
						(proc255_0 2 18)
					)
					(else (proc255_0 2 19) (= global148 4))
				)
				(self changeState: 3)
			)
			(3
				(newAct
					setLoop: (if (== gGGGGNorth 3) 2 else 0)
					setMotion: MoveTo (if gGGGNorth 166 else 72) -16 self
				)
			)
			(4 (global2 newRoom: 12))
		)
	)
)

(instance motivator of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 36
			setLoop: 0
			setCel: 0
			x: (if (== gGGGGNorth 1) 183 else 87)
			y: 169
			stopUpd:
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
					((Said '/motivator,artifact,device') (if global186 (proc255_0 2 20) else (proc255_0 2 21)))
					(
						(or
							(Said '/plug[<modular,8,spaceware]')
							(Said '/spaceware[<8]')
						)
						(proc255_0 2 22)
					)
					(
						(or
							(Said '[<down,below,at]/dirt,deck')
							(Said '<down,below,at[/dirt,deck]')
						)
						(proc255_0 2 23)
					)
				)
			)
			(
			(Said '(turn<on),begin/motivator,artifact,device') (proc255_0 2 24))
			(
				(Said
					'turn,get,manipulate,press,roll,drag/device,motivator,artifact'
				)
				(proc255_0 2 25)
			)
			(
			(Said 'remove,drag,press,get/plug[<modular,8,spaceware]') (proc255_0 2 26))
		)
	)
)

(instance door of Prop
	(properties
		view 12
	)
	
	(method (init)
		(super init:)
		(self
			cycleSpeed: 1
			setLoop: (if local4 0 else 1)
			setPri: (if (or (== gNorth 5) (== gNorth 3) (not local4))
				9
			else
				10
			)
			ignoreActors: 1
			posn: 138 115
			stopUpd:
		)
	)
)

(instance thump of Sound
	(properties
		number 56
		priority 2
	)
)

(instance doorSound of Sound
	(properties
		number 4
	)
)
