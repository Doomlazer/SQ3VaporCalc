;;; Sierra Script 1.0 - (do not remove this comment)
(script# 3)
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
	rm003 0
)
(synonyms
	(craft craft)
)

(local
	local0
	newAct
	local2
)
(instance rm003 of Rm
	(properties
		picture 3
		style $0000
		horizon 52
		north 2
		east 4
	)
	
	(method (init &tmp [temp0 50])
		(= global56 120)
		(if (!= gNorth 12)
			(self setLocales: 700 setFeatures: jupiter acme bow bore)
		)
		(if (== gNorth 12) (proc0_2) else (proc0_3))
		(if (== gNorth 12)
			(Load rsVIEW 258)
			(Load rsSOUND 76)
		else
			(Load rsVIEW 0)
			(Load rsVIEW 193)
			(Load rsVIEW 6)
		)
		(Load rsSOUND 45)
		(if (== gGGNorth gGNorth)
			(Load rsVIEW 36)
			(motivator init:)
		)
		(if (or (== gNorth 15) (== gNorth 4))
			(gEgo setLoop: -1)
		)
		(if (or (== gNorth 4) (== gNorth 15))
			(Load rsSOUND 11)
			(gLongSong number: 11 loop: -1 play:)
		)
		(super init:)
		(if (and (!= gNorth 15) (!= gNorth 4))
			(gEgo posn: 127 57 loop: 1)
		)
		(if (== gNorth 15)
			(if (not global133) (proc255_0 3 0) (= global133 1))
			(gEgo
				view: 6
				posn: 37 162
				setLoop: -1
				setPri: -1
				illegalBits: -32768
			)
		)
		(= global100 0)
		(if (== gNorth 12)
			(self setScript: grabScript)
		else
			(gEgo init:)
		)
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
		(if (or global100 (pEvent claimed?)) (return))
		(switch (pEvent type?)
			(evSAID
				(cond 
					((Said 'look>')
						(cond 
							((Said '/bow,bow,tie') (proc255_0 3 1))
							((Said '/acme') (proc255_0 3 2))
							((Said '/jup,2') (proc255_0 3 3))
							((Said '/nozzle') (proc255_0 3 4))
							(
							(and global133 (proc0_13 2 15) (Said 'look/ladder'))
								(if (gEgo inRect: 22 149 66 175)
									(proc255_0 3 5)
								else
									(proc255_0 3 6)
								)
							)
							(
							(and global133 (Said '[<in,in,through,at]/cavity'))
								(if (gEgo inRect: 22 149 66 175)
									(proc255_0 3 7)
								else
									(proc255_0 3 8)
								)
							)
							(
							(Said '[<in,through,at,in]/pane,port,(port<cavity)')
								(if (gEgo inRect: 39 148 105 167)
									(proc255_0 3 9)
								else
									(proc0_5)
								)
							)
							((Said '/box') (proc255_0 3 10))
							((Said '[<below,at]/iron') (proc255_0 3 11))
							((Said '[<around,at,in][/area,!*]') (proc255_0 3 12))
						)
					)
					(
					(Said 'break,open/pane,glass,aperture,port,(cavity<port)') (proc255_0 3 13))
					(
						(Said
							'hoist,manipulate,press,drag/craft,chute,bow,bow,tie,bore,acme,jup,2,(craft<flying)'
						)
						(proc255_0 3 14)
					)
					((Said 'listen[/sound]') (proc255_0 3 15))
					(
						(Said
							'open,board,enter,(climb[<in,in])/craft,bow,bow,tie,bore,acme,jup,2,(craft<flying),door'
						)
						(proc255_0 3 16)
					)
					((Said 'walk,climb[<on,up]/craft') (proc255_0 3 17))
					((Said 'clean') (proc255_0 3 18))
					((Said 'get,manipulate/box') (proc255_0 3 19))
					(
						(Said
							'erect,stand,place,drop,lower,use/ladder[/cavity[<in,in,in]]'
						)
						(if (or (gEgo has: 2) ((gInv at: 2) ownedBy: 8))
							(if (gEgo inRect: 22 149 66 175)
								(if (gEgo has: 2)
									(proc0_14 2 15)
									(gGame changeScore: -10)
									(proc255_0 3 20)
								else
									(proc255_0 3 21)
								)
							else
								(proc255_0 3 22)
							)
						else
							(pEvent claimed: 0)
							(return)
						)
					)
					((Said 'descend,climb,go[<down][/ladder,cavity]')
						(if global133
							(if (gEgo inRect: 22 149 66 175)
								(if
								(and (not (gEgo has: 2)) (not (proc0_13 2 8)))
									(gEgo hide:)
									(proc0_10)
									(global2 newRoom: 15)
								else
									(proc255_0 3 23)
								)
							else
								(proc255_0 3 22)
							)
						else
							(proc255_0 3 24)
						)
					)
					((Said 'use,get,climb/debris,scrap,iron')
						(if (gEgo inRect: 210 89 276 110)
							(gEgo setScript: bleedScript)
						else
							(proc255_0 3 25)
						)
					)
					((Said 'get/ladder')
						(if global133
							(if (and (not (gEgo has: 2)) (not global134))
								(if (gEgo inRect: 22 149 66 175)
									(gGame changeScore: 10)
									(gEgo get: 2)
									(proc255_0 3 26)
									(proc255_0 3 27)
								else
									(proc255_0 3 22)
								)
							else
								(proc255_0 3 28)
							)
						else
							(proc255_0 3 29)
						)
					)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if
		(or (== newRoomNumber 15) (== newRoomNumber 4))
			(gLongSong stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global100 1)
				(gEgo hide:)
				(proc255_0 3 30)
				(Timer set: self 2)
				(fallTune play:)
			)
			(1
				(proc255_0 3 31)
				(proc0_17 901 0 0 1)
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
					setPri: 8
					setStep: 1 2
					x: (if gGGGNorth 249 else 81)
					y: -16
					illegalBits: 0
					ignoreHorizon: 1
					ignoreActors: 1
					init:
					setCycle: Fwd
					setMotion: MoveTo (if gGGGNorth 249 else 81) 99 self
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
						(proc255_0 3 32)
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
						(proc255_0 3 33)
					)
					(else (proc255_0 3 34) (= global148 4))
				)
				(self changeState: 3)
			)
			(3
				(newAct
					setLoop: (if (== gGGGGNorth 3) 2 else 0)
					setMotion: MoveTo (if gGGGNorth 249 else 81) -16 self
				)
			)
			(4 (global2 newRoom: 12))
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
					illegalBits: 0
					setLoop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
				(= local2 (proc255_0 3 35 91))
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
				(proc255_0 3 36 67 -1 20 70 280)
				(proc0_17 901 0 6 8)
			)
		)
	)
)

(instance motivator of Act
	(properties
		view 36
	)
	
	(method (init)
		(super init:)
		(self
			setLoop: 0
			setCel: 0
			x: (if (== gGGGGNorth 1) 264 else 96)
			y: 115
			setPri: 7
			stopUpd:
		)
	)
	
	(method (handleEvent pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			((Said 'look>')
				(cond 
					((Said '/motivator,artifact,device') (if global186 (proc255_0 3 37) else (proc255_0 3 38)))
					(
						(or
							(Said '/plug[<modular,8,spaceware]')
							(Said '/spaceware[<8]')
						)
						(proc255_0 3 39)
					)
					((Said '[<down,below,at][/dirt,deck]') (proc255_0 3 40))
				)
			)
			(
				(Said
					'turn,get,manipulate,press,roll,drag/motivator,artifact,device'
				)
				(proc255_0 3 41)
			)
			(
			(Said '(turn<on),begin/motivator,artifact,device') (proc255_0 3 42))
			(
			(Said 'press,drag,remove,get/plug[<modular,8,spaceware]') (proc255_0 3 43))
		)
	)
)

(instance jupiter of Feature
	(properties
		y 75
		x 269
	)
	
	(method (handleEvent pEvent)
		(cond 
			(
			(or (pEvent claimed?) (!= (pEvent type?) evSAID)) (return))
			((Said 'look/craft') (proc255_0 3 3))
		)
	)
)

(instance bow of Feature
	(properties
		y 144
		x 61
	)
	
	(method (handleEvent pEvent)
		(cond 
			(
			(or (pEvent claimed?) (!= (pEvent type?) evSAID)) (return))
			((Said 'look/craft,bow,tie,bow') (proc255_0 3 1))
		)
	)
)

(instance bore of Feature
	(properties
		y 138
		x 212
	)
	
	(method (handleEvent pEvent)
		(cond 
			(
			(or (pEvent claimed?) (!= (pEvent type?) evSAID)) (return))
			((Said 'look/craft,bore,implement') (proc255_0 3 44))
		)
	)
)

(instance acme of Feature
	(properties
		y 85
		x 172
	)
	
	(method (handleEvent pEvent)
		(cond 
			(
			(or (pEvent claimed?) (!= (pEvent type?) evSAID)) (return))
			((Said 'look/craft') (proc255_0 3 45))
		)
	)
)

(instance fallTune of Sound
	(properties
		number 45
		priority 5
	)
)
