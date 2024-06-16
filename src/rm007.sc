;;; Sierra Script 1.0 - (do not remove this comment)
(script# 7)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Timer)
(use Sound)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	rm007 0
)

(local
	local0
	newAct
)
(instance rm007 of Rm
	(properties
		picture 7
		style $0000
		horizon 10
		west 6
	)
	
	(method (init &tmp [temp0 50])
		(if (== gNorth 11)
			(Load rsVIEW 258)
			(Load rsSOUND 76)
		else
			(self setLocales: 700)
			(Load rsVIEW 0)
			(Load rsVIEW 6)
			(Load rsVIEW 14)
			(Load rsVIEW 17)
			(Load rsSOUND 45)
		)
		(if (== gGGNorth gGNorth)
			(Load rsVIEW 36)
			(motivator init:)
		)
		(if (== gNorth 6)
			(gEgo view: 0)
		else
			(Load rsSOUND 56)
		)
		(super init:)
		(self setScript: rmScript)
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
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'look>')
				(cond 
					((Said '[<at,around,in][/area,!*]') (proc255_0 7 0))
					((Said '<in,at,in,in/craft,stage,wreck') (proc255_0 7 1))
					((Said '/craft,stage,wreck') (proc255_0 7 2))
					((Said '/head,android,artifact,helmet') (proc255_0 7 3))
					((Said '/eye[<broken,glass,android]') (proc255_0 7 4))
					((Said '<in,in,in/android,eye[<broken,glass]') (proc255_0 7 5))
					((Said '[<at,in,through,in]/grate') (proc255_0 7 6))
					((Said '/whip,(programmer<dense,metallic)') (proc255_0 7 7))
					(
						(or
							(Said '[<down,below,at]/dirt,deck')
							(Said '<down,below,at[/dirt,deck]')
						)
						(proc255_0 7 8)
					)
					((Said '/down,(edge[<deck])')
						(if (gEgo inRect: 32 156 192 189)
							(proc255_0 7 9)
						else
							(proc0_5)
						)
					)
				)
			)
			((Said 'craft') (proc255_0 7 10))
			(
				(Said
					'enter,climb,crawl,go[<on,in,in,through,up,in][/android,eye,head,pane[<broken,to]]'
				)
				(if (gEgo inRect: 160 163 178 180)
					(rmScript changeState: 4)
				else
					(proc255_0 7 11)
				)
			)
			(
			(Said 'enter,climb[<in,in,up,in]/grate[<android]') (proc255_0 7 12))
			(
			(Said 'manipulate,press,drag,hoist/head,android,helmet') (proc255_0 7 13))
			((Said 'climb<down') (proc255_0 7 14))
			((Said 'get/head') (proc255_0 7 15))
			((Said 'give/head') (proc255_0 7 16))
			((Said 'break,remove/android,eye[<broken,glass]') (proc255_0 7 17))
		)
	)
	
	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (doit)
		(if
		(and (== (gEgo onControl: 0) 2) (!= (gEgo view?) 17))
			(self changeState: 1)
		)
		(super doit:)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gNorth 11)
					(self setScript: grabScript)
				else
					(gEgo setStep: -1 2)
					(if (== gNorth 8)
						(gEgo
							view: 14
							cel: (gEgo lastCel:)
							illegalBits: 0
							posn: 195 171
							setPri: 13
							init:
							cycleSpeed: 1
						)
						(self changeState: 6)
					else
						(gEgo posn: 9 113 init:)
					)
				)
			)
			(1
				(proc0_2)
				(gEgo
					illegalBits: 0
					view: 17
					cel: 0
					setLoop: 2
					cycleSpeed: 2
					setCycle: End self
					setMotion: 0
				)
			)
			(2
				(thump number: 45 play:)
				(gEgo
					setCycle: 0
					setStep: -1 15
					setMotion: MoveTo (gEgo x?) 240 self
				)
			)
			(3
				(proc255_0 7 18)
				(proc0_17 901 0 0 1)
				(return)
			)
			(4
				(proc0_2)
				(gEgo
					illegalBits: 0
					view: 14
					cel: 0
					posn: 195 171
					setPri: 13
					setCycle: End self
					setMotion: 0
					cycleSpeed: 1
				)
			)
			(5
				(if (not global596)
					(= global596 1)
					(gGame changeScore: 5)
				)
				(global2 newRoom: 8)
			)
			(6
				(gEgo cycleSpeed: 1 setCycle: Beg self)
			)
			(7
				(thump number: 56 play:)
				(proc0_3)
				(gEgo
					view: 0
					setLoop: -1
					setPri: -1
					posn: 168 169
					loop: 2
					cel: 0
					setCycle: Walk
					setStep: 3 2
					illegalBits: -32768
					moveSpeed: 0
					cycleSpeed: 0
				)
			)
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
			setStep: 1 1
			illegalBits: 0
			x: (if (== gGGGGNorth 1) 217 else 119)
			y: 81
			setPri: 4
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
					((Said '/motivator,artifact,device') (if global186 (proc255_0 7 19) else (proc255_0 7 20)))
					(
						(or
							(Said '/plug[<modular,8,spaceware]')
							(Said '/spaceware[<8]')
						)
						(proc255_0 7 21)
					)
					((Said '[<down,below,at][/dirt,deck]') (proc255_0 7 22))
				)
			)
			(
				(Said
					'remove,get,manipulate,press,roll,drag/motivator,artifact,device'
				)
				(proc255_0 7 23)
			)
			(
			(Said '(turn<on),begin/motivator,artifact,device') (proc255_0 7 24))
			(
			(Said 'remove,press,drag,get/plug[<modular,8,spaceware]') (proc255_0 7 25))
		)
	)
)

(instance grabScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((= newAct (Act new:))
					name: {Claw}
					view: 258
					setLoop: (if (== gGGGGNorth 3) 2 else 0)
					setPri: 5
					setStep: 1 2
					x: (if gGGGNorth 202 else 105)
					y: -19
					illegalBits: 0
					ignoreHorizon: 1
					ignoreActors: 1
					init:
					setCycle: Fwd
					setMotion: MoveTo (if gGGGNorth 202 else 105) 65 self
				)
			)
			(1 (Timer set: self 2))
			(2
				(cond 
					((== gGGGGNorth 3)
						(= global148 4)
						(= gGGGGNorth gGGGNorth)
						(motivator init:)
						(= gGGNorth gGNorth)
						(gLongSong number: 76 loop: 1 play:)
						(gGame changeScore: -15)
						(proc0_10)
						(proc255_0 7 26)
					)
					(
					(and (== gGGNorth gGNorth) (== gGGGGNorth gGGGNorth))
						(newAct setLoop: 2)
						(motivator hide:)
						(= gGGNorth 0)
						(= gGGGGNorth 3)
						(= global148 5)
						(gLongSong number: 76 loop: 1 play:)
						(gGame changeScore: 15)
						(proc0_10)
						(proc255_0 7 27)
					)
					(else (proc255_0 7 28) (= global148 4))
				)
				(self changeState: 3)
			)
			(3
				(newAct
					setLoop: (if (== gGGGGNorth 3) 2 else 0)
					setMotion: MoveTo (newAct x?) -19 self
				)
			)
			(4 (global2 newRoom: 11))
		)
	)
)

(instance thump of Sound
	(properties
		number 56
		priority 5
	)
)
