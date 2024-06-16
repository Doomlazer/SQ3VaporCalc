;;; Sierra Script 1.0 - (do not remove this comment)
(script# 8)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Rev)
(use Timer)
(use Avoid)
(use Sound)
(use Jump)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	rm008 0
)

(local
	local0
	local1
	local2
	gEgoLoop
	local4
	local5
	local6
	local7
	local8
)
(instance rm008 of Rm
	(properties
		picture 8
		style $0000
		horizon 1
	)
	
	(method (init &tmp [temp0 50])
		(proc0_2)
		(= global54 1)
		(= global56 120)
		(if (!= gNorth 11)
			(self
				setLocales: 700
				setFeatures: thePod theMallard
				setScript: rmScript
			)
		)
		(Load rsSCRIPT 991)
		(= local7 991)
		(Load rsVIEW 16)
		(Load rsVIEW 6)
		(Load rsVIEW 19)
		(Load rsVIEW 21)
		(Load rsVIEW 29)
		(Load rsVIEW 257)
		(Load rsVIEW 750)
		(Load rsVIEW 193)
		(Load rsSOUND 11)
		(Load rsSOUND 56)
		(if (and (!= gGGGGNorth 4) (== gGGNorth gGNorth))
			(Load rsVIEW 36)
			(motivator init:)
		)
		(cond 
			((== gNorth 14)
				(= local1 1)
				((gInv at: 2) moveTo: 8)
				(gLongSong number: 11 loop: -1 play:)
			)
			((== gNorth 11)
				(Load rsVIEW 258)
				(Load rsSOUND 76)
				(= local4 (if gGGGNorth 215 else 51))
				(= local5 (if gGGGNorth 67 else 139))
			)
			(else
				(gEgo
					view: 19
					setLoop: 0
					illegalBits: 0
					ignoreHorizon: 1
					posn: 251 14
					setStep: 1 1
					setPri: -1
					init:
					moveSpeed: 1
					cycleSpeed: 1
					setCycle: Rev
					setMotion: MoveTo 251 47 rmScript
					setScript: rmScript
				)
			)
		)
		(if (proc0_13 2) (ladder init: stopUpd:))
		(hatch init:)
		(super init:)
		(if (== gNorth 11) (self setScript: grabScript))
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
		(DisposeScript 991)
		(super dispose:)
	)
	
	(method (handleEvent pEvent param2 &tmp [temp0 50])
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'look>')
				(cond 
					((Said '/scrap,iron,debris,garbage') (proc255_0 8 0))
					((Said '/handle[<craft,aluminum,door]') (if local0 (proc255_0 8 1) else (proc255_0 8 2)))
					((Said '/chute,(craft<little)')
						(switch (= param2 (Random 1 2))
							(1 (proc255_0 8 3))
							(2 (proc255_0 8 4))
						)
					)
					((Said '/aluminum,craft[<big]') (proc255_0 8 5))
					((Said '/nozzle') (proc255_0 8 6))
					((Said '/engine') (proc255_0 8 7))
					((Said '/neck,android,head') (proc255_0 8 8))
					(
						(and
							(not local0)
							(Said
								'[<in,through,in,in]/cavity[<chute,little,cavity,pyramid]'
							)
						)
						(if (gEgo inRect: 2 64 91 109)
							(proc255_0 8 9)
						else
							(proc255_0 8 10)
						)
					)
					(
						(or
							(Said '<in,in,in/chute,craft')
							(Said '[<at,in,through,in]/pane,port,(cavity<port)')
							(Said '/cabin,chair[<scum]')
						)
						(cond 
							((gEgo inRect: 44 105 87 116) (proc255_0 8 11))
							((gEgo inRect: 59 117 170 162) (proc255_0 8 12))
							(else (proc0_5))
						)
					)
					((Said '/console[<craft]')
						(if (gEgo inRect: 59 117 170 162)
							(proc255_0 8 13)
						else
							(proc255_0 8 14)
						)
					)
					(
					(Said '[<in,in,in]/motivator,cavity,compartment')
						(if (and local0 (gEgo inRect: 193 75 260 89))
							(if (== gGGGGNorth 4)
								(proc255_0 8 15)
							else
								(proc255_0 8 16)
							)
						else
							(proc255_0 8 17)
						)
					)
					(
						(or
							(Said '/plug[<modular,8,spaceware]')
							(Said '/spaceware[<8]')
						)
						(if local0
							(if (== gGGNorth 4)
								(proc255_0 8 18)
							else
								(proc255_0 8 19)
							)
						else
							(proc255_0 8 20)
						)
					)
					((Said '/leggo,domino,artifact') (proc255_0 8 21))
					((Said '/ladder')
						(if (proc0_13 2)
							(proc255_0 8 22)
						else
							(pEvent claimed: 0)
						)
					)
					((Said '/door') (if local0 (proc255_0 8 23) else (proc255_0 8 20)))
					((Said '/stair') (proc255_0 8 24))
					((Said '/tube,hose,conduit') (proc255_0 8 25))
					((Said '[<around,at,in][/area,!*]') (proc255_0 8 26))
				)
			)
			(
			(Said '(play[<with]),use[/leggo,domino,artifact]') (proc255_0 8 27))
			(
				(Said
					'hoist,manipulate,press,drag/craft,chute,aluminum[<escape,big,little]'
				)
				(proc255_0 8 28)
			)
			((Said 'get>')
				(cond 
					((Said '/plug[<modular]') (if local0 (proc255_0 8 29) else (pEvent claimed: 0)))
					((Said '/leggo,domino,artifact') (proc255_0 8 30))
					((Said '/ladder')
						(if (proc0_13 2)
							(cond 
								((and global194 (gEgo inRect: 220 115 274 140))
									(gEgo get: 2)
									(ladder dispose:)
									(gGame changeScore: -5)
									(proc255_0 8 31)
									(proc255_0 8 32)
									(= global194 0)
								)
								((gEgo inRect: 215 114 226 121)
									(gEgo get: 2)
									(ladder dispose:)
									(gGame changeScore: -5)
									(proc255_0 8 31)
									(proc255_0 8 32)
								)
								(local0 (proc255_0 8 33))
								(else (proc0_5))
							)
						else
							(proc255_0 8 34)
						)
					)
				)
			)
			((Said 'enter/!*') (proc255_0 8 35))
			((Said 'call/diagnostic') (proc255_0 8 36))
			(
				(and
					(gEgo inRect: 193 75 260 89)
					(Said 'enter/cavity,compartment')
				)
				(proc255_0 8 37)
			)
			(
				(Said
					'use,erect,drop,stand,place[<up,on]/ladder/chute,(craft<little)'
				)
				(proc255_0 8 38)
			)
			(
				(or
					(Said 'open,enter/door[<craft,aluminum]')
					(Said 'turn/handle[<craft,aluminum,door]')
					(Said 'get<in[/craft,aluminum]')
					(Said 'board,enter,(get<in)/craft,aluminum')
					(Said 'climb<in,through/door')
				)
				(if local0
					(if (gEgo inRect: 165 77 208 96)
						(hatchScript changeState: 1)
					else
						(proc0_5)
					)
				else
					(proc255_0 8 2)
				)
			)
			(
				(or
					(Said 'open,enter,(get<in,in)/door<chute,(craft<little)')
					(Said 'climb/chute,(craft<little,escape)')
				)
				(proc255_0 8 39)
			)
			((Said 'cable,generator') (proc255_0 8 40))
			(
				(or
					(Said 'plug,afix/motivator,device,artifact')
					(Said 'use/plug')
				)
				(proc255_0 8 41)
			)
			((Said 'close/door') (proc255_0 8 42))
			(
				(Said
					'use,erect,drop,stand,place[<up,on,down]/ladder[/craft]'
				)
				(if (gEgo has: 2)
					(cond 
						((gEgo inRect: 175 105 270 168) (gEgo setScript: ladderScript))
						((gEgo inRect: 2 64 91 109) (proc255_0 8 43))
						(else (proc255_0 8 44))
					)
				else
					(proc255_0 8 45)
				)
			)
			(
				(Said
					'use,get,climb/debris,scrap,iron,artifact,domino,pole,blade'
				)
				(if (gEgo inRect: 17 122 61 155)
					(gEgo setScript: bleedScript)
				else
					(proc255_0 8 46)
				)
			)
			(
				(Said
					'climb,crawl[<through,in,in]/pane,port,(cavity<port)'
				)
				(proc255_0 8 47)
			)
			(
				(or
					(Said
						'enter,(climb<in,through,in,in)/cavity[<chute,little]'
					)
					(Said
						'reach,appendage<in,in,in/cavity,chute,craft[<little]'
					)
					(Said
						'reach,appendage<in,in,in/appendage/cavity,chute,craft[<little]'
					)
				)
				(if (gEgo inRect: 2 64 91 109)
					(proc255_0 8 48)
				else
					(proc0_5)
				)
			)
			((Said 'descend,climb[<down,up]/ladder')
				(cond 
					((proc0_13 2)
						(cond 
							((== (ladder cel?) 1) (gEgo setScript: climbLadderScript))
							((== (ladder cel?) 2) (proc255_0 8 49))
							(else (proc255_0 8 50))
						)
					)
					((gEgo has: 2) (proc255_0 8 51))
					(else (proc255_0 8 52))
				)
			)
			((Said 'climb[<!*][/!*]')
				(cond 
					((gEgo inRect: 241 48 261 55) (rmScript changeState: 2))
					(
						(or
							(gEgo inRect: 193 73 222 102)
							(gEgo inRect: 215 114 226 121)
						)
						(if (proc0_13 2)
							(cond 
								((== (ladder cel?) 1) (gEgo setScript: climbLadderScript))
								((== (ladder cel?) 2) (proc255_0 8 49))
								(else (proc255_0 8 50))
							)
						else
							(proc255_0 8 53)
						)
					)
					(else (proc255_0 8 54))
				)
			)
			((Said 'climb[<in]/chute') (proc255_0 8 55))
			(
				(or
					(Said 'climb[<down,off]/ladder,craft,aluminum,aluminum')
					(Said 'climb<down,off')
					(Said 'descend/ladder,craft,aluminum,aluminum')
				)
				(if (gEgo inRect: 193 73 222 102)
					(if (proc0_13 2)
						(cond 
							((== (ladder cel?) 1) (gEgo setScript: climbLadderScript))
							((== (ladder cel?) 2) (proc255_0 8 49))
							(else (proc255_0 8 50))
						)
					else
						(proc255_0 8 53)
					)
				else
					(pEvent claimed: 0)
				)
			)
			((Said 'climb,(climb<up)[/!*]')
				(cond 
					((gEgo inRect: 241 48 261 55) (rmScript changeState: 2))
					((gEgo inRect: 215 114 226 121)
						(if (proc0_13 2)
							(cond 
								((== (ladder cel?) 1) (gEgo setScript: climbLadderScript))
								((== (ladder cel?) 2) (proc255_0 8 49))
								(else (proc255_0 8 50))
							)
						else
							(proc255_0 8 53)
						)
					)
					(else (proc255_0 8 54))
				)
			)
			((Said 'descend,(climb<down)[/!*]')
				(if (gEgo inRect: 193 73 222 102)
					(if (proc0_13 2)
						(cond 
							((== (ladder cel?) 1) (gEgo setScript: climbLadderScript))
							((== (ladder cel?) 2) (proc255_0 8 49))
							(else (proc255_0 8 50))
						)
					else
						(proc255_0 8 53)
					)
				else
					(proc255_0 8 54)
				)
			)
		)
		(if
		(Said 'climb,climb/neck,head,android,nerve,cable')
			(if (gEgo inRect: 241 48 261 55)
				(rmScript changeState: 2)
			else
				(proc0_5)
			)
		)
		(if
			(or
				(Said 'climb[<up,on,to]/neck,head,android,nerve,cable')
				(Said 'climb<up,on')
				(Said 'climb/neck,head,android,nerve,cable')
			)
			(if (gEgo inRect: 241 48 261 55)
				(rmScript changeState: 2)
			else
				(pEvent claimed: 0)
			)
		)
		(if
			(or
				(Said 'climb[<up,on]/ladder,craft,aluminum,aluminum')
				(Said 'climb<up,on')
				(Said 'climb/ladder,craft,aluminum,aluminum')
			)
			(if (gEgo inRect: 215 114 226 121)
				(if (proc0_13 2)
					(cond 
						((== (ladder cel?) 1) (gEgo setScript: climbLadderScript))
						((== (ladder cel?) 2) (proc255_0 8 49))
						(else (proc255_0 8 50))
					)
				else
					(proc255_0 8 56)
				)
			else
				(proc255_0 8 54)
			)
		)
		(if (Said 'break/pane,glass') (proc255_0 8 57))
	)
)

(instance rmScript of Script
	(properties)
	
	(method (doit)
		(if
		(and (not global155) (not global100) (== local0 1))
			(if
				(or
					(== (gEgo onControl: 0) 8193)
					(== (gEgo onControl: 0) -24576)
					(== (gEgo onControl: 0) -24575)
					(== (gEgo onControl: 0) 24577)
				)
				(= local2 1)
			)
			(if
				(or
					(== (gEgo onControl: 0) 4097)
					(== (gEgo onControl: 0) 20481)
					(== (gEgo onControl: 0) -12287)
				)
				(if (< (gEgo x?) 175) (= local2 3) else (= local2 2))
			)
			(if (> local2 0)
				(= local0 0)
				(proc0_2)
				(self changeState: 4)
				(= global100 1)
				(= gEgoLoop (gEgo loop?))
			)
		)
		(super doit:)
	)
	
	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(1
				(proc0_3)
				(= global100 0)
				(gEgo
					view: 0
					setCycle: Walk
					setLoop: -1
					loop: 2
					moveSpeed: 0
					cycleSpeed: 0
					setStep: 3 2
				)
				(if (!= local1 1)
					(gEgo posn: 250 54 setPri: -1 illegalBits: -16384)
				else
					(= local0 1)
					(gEgo posn: 207 86 illegalBits: 0)
					(= local1 0)
				)
			)
			(2
				(proc0_2)
				(= global100 1)
				(gEgo
					view: 19
					setLoop: 0
					setStep: 1 1
					illegalBits: 0
					posn: 251 47
					setMotion: MoveTo 251 13 self
					setCycle: Fwd
					moveSpeed: 1
					cycleSpeed: 1
				)
			)
			(3 (global2 newRoom: 7))
			(4
				(gEgo
					setMotion: 0
					view: 257
					setLoop: (gEgo loop?)
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(5
				(gEgo
					setStep: -1 10
					setCycle: 0
					ignoreActors:
					illegalBits: 0
				)
				(if (== local2 1)
					(gEgo setPri: 4)
					(if (< (gEgo x?) 175)
						(gEgo setMotion: JumpTo (gEgo x?) 134 self)
					else
						(gEgo setMotion: JumpTo (gEgo x?) 110 self)
					)
				)
				(if (== local2 3)
					(gEgo
						setStep: 10
						setMotion: MoveTo (- (gEgo x?) 32) 138 self
					)
				)
				(if (== local2 2)
					(gEgo
						setStep: -1 15
						setMotion: JumpTo (+ (gEgo x?) 10) (+ (gEgo y?) 30) self
					)
				)
			)
			(6
				(cond 
					((== local2 3)
						(gEgo view: 750 setLoop: 1 setCel: 2)
						(Timer setReal: self 3)
						(self state: (+ state 1))
						(thump play:)
					)
					((== local2 2)
						(gEgo view: 16 loop: 0 cel: 0 stopUpd:)
						(Timer setCycle: self 2)
					)
					(else (gEgo hide:) (Timer set: self 2))
				)
			)
			(7
				(proc255_0 8 58)
				(proc0_17 901 0 15 1)
				(proc0_3)
			)
			(8
				(gEgo
					view: 0
					setStep: 3 2
					setLoop: -1
					setPri: -1
					setCycle: Walk
					cycleSpeed: 0
					ignoreActors: 0
					illegalBits: -16384
				)
				(= global100 0)
				(if (not global194) (ladder setPri: 8 forceUpd:))
				(= local2 0)
				(= local0 0)
				(proc0_10)
				(proc255_0 8 59)
				(proc0_3)
			)
		)
	)
)

(instance bleedScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					view: 193
					setLoop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
				(= local6 (proc255_0 8 60 91))
			)
			(1
				(gEgo setLoop: 1 cel: 0 cycleSpeed: 1 setCycle: Fwd)
				(= seconds 4)
				(proc0_12)
			)
			(2
				(gEgo cycleSpeed: 3)
				(= cycles 25)
			)
			(3
				(gEgo cycleSpeed: 6)
				(= seconds 4)
			)
			(4
				(gEgo cycleSpeed: 3)
				(= cycles 25)
			)
			(5
				(gEgo cel: 0 setCycle: 0)
				(proc0_10)
				(proc255_0 8 61 67 -1 20 70 280)
				(proc0_17 901 0 6 8)
			)
		)
	)
)

(instance hatchScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local1 1)
					(self changeState: 2)
				else
					(hatch stopUpd:)
				)
			)
			(1
				(gEgo setMotion: 0 posn: 205 86)
				(proc0_2)
				(proc255_0 8 62)
				(= cycles 2)
			)
			(2
				(hatch startUpd: setCycle: End self)
			)
			(3
				(if (== local1 1) (self state: (+ state 1)))
				(= seconds 2)
			)
			(4
				(gEgo
					view: 21
					posn: 202 87
					setLoop: 1
					cel: 0
					setMotion: 0
					setCycle: End self
					cycleSpeed: 1
				)
				(self state: (+ state 1))
			)
			(5
				(gEgo
					view: 21
					posn: 202 87
					setLoop: 1
					cel: 7
					init:
					setPri: 9
					setMotion: 0
					setCycle: Beg self
					cycleSpeed: 1
				)
			)
			(6
				(if (not local1)
					(gLongSong fade:)
					(if (not global231)
						(= global231 1)
						(gGame changeScore: 10)
					)
					(global2 newRoom: 14)
				else
					(= cycles 5)
				)
			)
			(7
				(hatch setCycle: Beg self)
				(rmScript changeState: 1)
			)
			(8 (hatch stopUpd:))
		)
	)
)

(instance ladderScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(global2 setScript: rmScript)
				(gEgo setAvoider: Avoid setMotion: MoveTo 220 120 self)
			)
			(1
				(proc0_14 2 gGNorth)
				(gGame changeScore: 5)
				(gEgo setAvoider: 0 loop: 1)
				(ladder init: ignoreActors: 1 stopUpd:)
				(DisposeScript 985)
				(proc0_3)
			)
		)
	)
)

(instance climbLadderScript of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 50])
		(switch (= state newState)
			(0
				(= global100 1)
				(proc0_2)
				(gEgo
					view: 19
					setLoop: 0
					illegalBits: 0
					ignoreActors: 1
					x: 220
					y: (if local0 103 else 119)
					setPri: 9
				)
				(if (not local0)
					(gEgo setMotion: MoveTo 220 103 self)
				else
					(ladder setPri: 8 forceUpd:)
					(gEgo setMotion: MoveTo 220 119 self setCycle: Rev)
				)
			)
			(1
				(proc0_3)
				(= global100 0)
				(gEgo
					view: 0
					setLoop: -1
					setCycle: Walk
					setStep: 3 2
					ignoreActors: 0
				)
				(if (not local0)
					(= local0 1)
					(ladder setPri: 10 forceUpd:)
					(gEgo setPri: 9 illegalBits: 0 posn: 216 89)
					(proc0_10)
					(global2 setScript: rmScript)
					(proc255_0 8 63)
				else
					(gEgo setPri: -1 illegalBits: -16384 posn: 220 120)
					(= local2 0)
					(= local0 0)
				)
			)
		)
	)
)

(instance grabScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(claw init: setMotion: MoveTo local4 local5 self)
			)
			(1 (= cycles 15))
			(2
				(cond 
					((== gGGGGNorth 3)
						(if (== gGGGNorth 1)
							(gLongSong number: 76 loop: 1 play:)
							(gGame changeScore: 15)
							(proc0_10)
							(proc255_0 8 64)
							(= gGGGGNorth 4)
							(= gGGNorth gGGGNorth)
						else
							(gLongSong number: 76 loop: 1 play:)
							(gGame changeScore: -15)
							(proc0_10)
							(proc255_0 8 65)
							(motivator init:)
							(= gGGNorth gGNorth)
							(= gGGGGNorth gGGGNorth)
						)
						(= global148 4)
					)
					(
						(and
							(== gGGGGNorth gGGGNorth)
							(or (== gGGNorth gGNorth) (== gGGGGNorth 4))
						)
						(claw setLoop: 2)
						(if (!= gGGGNorth 1) (motivator hide:))
						(= gGGNorth 0)
						(= gGGGGNorth 3)
						(= global148 5)
						(gLongSong number: 76 loop: 1 play:)
						(gGame changeScore: 15)
						(proc0_10)
						(proc255_0 8 66)
					)
					(else (proc255_0 8 67) (= global148 4))
				)
				(= cycles 2)
			)
			(3
				(claw
					setLoop: (if (== gGGGGNorth 3) 2 else 0)
					setMotion: MoveTo local4 -19 self
				)
			)
			(4 (global2 newRoom: 11))
		)
	)
)

(instance ladder of View
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 29
			loop: 0
			cel: (if global194 2 else 1)
			ignoreActors: 1
			posn: (if global194 242 else 219) (if global194 131 else 114)
			setPri: (cond 
				(global194 4)
				(local0 10)
				(else 8)
			)
		)
	)
)

(instance hatch of Prop
	(properties
		view 21
	)
	
	(method (init)
		(super init:)
		(self
			ignoreActors: 1
			setPri: 8
			posn: 188 89
			setScript: hatchScript
			cycleSpeed: 1
		)
	)
)

(instance claw of Act
	(properties)
	
	(method (init)
		(super init:)
		(self
			view: 258
			setLoop: (if (== gGGGGNorth 3) 2 else 0)
			setPri: 15
			setStep: 1 2
			illegalBits: 0
			ignoreHorizon: 1
			ignoreActors: 1
			posn: local4 -19
			setCycle: Fwd
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
			posn: 66 155
			setStep: 1 3
			setPri: 11
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
					((Said '/motivator,artifact,device') (if global186 (proc255_0 8 68) else (proc255_0 8 69)))
					((Said '/plug[<modular,8,spaceware]') (proc255_0 8 70))
					((Said '[<down,below,at][/dirt,deck]') (proc255_0 8 71))
				)
			)
			(
				(Said
					'remove,turn,get,manipulate,press,roll,drag/motivator,artifact,device'
				)
				(proc255_0 8 72)
			)
			(
				(Said
					'(turn<on),begin/motivator,artifact,device[<little,round]'
				)
				(proc255_0 8 73)
			)
			(
			(Said 'remove,drag,press,get/plug[<modular,8,spaceware]') (proc255_0 8 74))
		)
	)
)

(instance thump of Sound
	(properties
		number 56
		priority 2
	)
)

(instance thePod of Feature
	(properties
		y 104
		x 54
	)
	
	(method (handleEvent pEvent param2)
		(cond 
			(
			(or (pEvent claimed?) (!= (pEvent type?) evSAID)) (return))
			((Said 'look/craft,chute[<little]')
				(switch (= param2 (Random 1 2))
					(1 (proc255_0 8 75))
					(2 (proc255_0 8 76))
				)
			)
		)
	)
)

(instance theMallard of Feature
	(properties
		y 106
		x 187
	)
	
	(method (handleEvent pEvent)
		(cond 
			(
			(or (pEvent claimed?) (!= (pEvent type?) evSAID)) (return))
			((Said 'look/craft,aluminum[<big]') (proc255_0 8 5))
		)
	)
)
