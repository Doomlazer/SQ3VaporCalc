;;; Sierra Script 1.0 - (do not remove this comment)
(script# 4)
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
	rm004 0
)
(synonyms
	(craft craft)
)

(local
	newAct
)
(instance rm004 of Rm
	(properties
		picture 4
		style $0000
		west 3
	)
	
	(method (init &tmp [temp0 50])
		(if (!= gNorth 9)
			(self setLocales: 700)
		else
			(proc0_2)
		)
		(SL enable:)
		(Load rsVIEW 13)
		(if (== gGGNorth gGNorth)
			(Load rsVIEW 36)
			(motivator init:)
		)
		(if (== gNorth 9)
			(Load rsVIEW 258)
			(Load rsSOUND 76)
		else
			(Load rsVIEW 0)
			(Load rsVIEW 6)
			(gEgo init:)
		)
		(Load rsSOUND 41)
		(gLongSong number: 41 loop: -1 priority: 1 play:)
		(bucket init:)
		(super init:)
		(if (== gNorth 9)
			(gEgo setScript: grabScript)
		else
			(proc0_3)
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
		(if
			(and
				(gCast contains: gEgo)
				(== (gEgo onControl: 0) 3)
				(> (bucket y?) 89)
				(< (bucket y?) 105)
			)
			(proc0_2)
			(gEgo dispose:)
			(bucket setCel: 2)
			(if (not global239)
				(= global239 1)
				(gGame changeScore: 5)
			)
			(= global132 1)
		)
		(super doit:)
	)
	
	(method (handleEvent pEvent)
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(cond 
					((Said 'look>')
						(cond 
							(
							(Said '/bucket,conveyer,device,elevator,hoist[/belt]') (proc255_0 4 0))
							((Said '[<around,at,in][/area,!*]') (proc255_0 4 1))
							(
								(Said
									'[<at]/appendage,finger,appendage,branch[<android,big]'
								)
								(proc255_0 4 2)
							)
							((Said '/jup,craft,2,chute') (proc255_0 4 3))
							(
							(Said '[<in,in,through,at]/craft,pane,port,jup,2,chute') (proc255_0 4 4))
							((Said '/nozzle') (proc255_0 4 5))
							((Said '/cog,wheel') (proc255_0 4 6))
							((Said '/box,pulley,dome,pole') (proc255_0 4 7))
							((Said '/pit') (proc255_0 4 8))
						)
					)
					(
						(Said
							'cease,(turn<off),(close<down)/conveyer,elevator,hoist'
						)
						(proc255_0 4 9)
					)
					(
						(Said
							'break,open/pane,glass,aperture,port,(cavity<port),finger,appendage,appendage'
						)
						(proc255_0 4 10)
					)
					(
						(Said
							'board,enter,(get<on,onto,in,in),(climb,stair<in,up,in,onto,on)/bucket,conveyer,tower'
						)
						(proc255_0 4 11)
					)
					((Said 'climb[<on,up]/craft,chute,jup,2') (proc255_0 4 12))
					(
					(Said 'hoist,manipulate,press,drag/craft,chute,jup,2') (proc255_0 4 13))
					(
						(Said
							'bite,tickle,buff/appendage,appendage[<android,big,green]'
						)
						(proc255_0 4 14)
					)
					(
						(Said
							'get,manipulate,drag,press,hoist[<up]/box,pulley,dome,pole'
						)
						(proc255_0 4 15)
					)
					(
						(Said
							'get,manipulate,drag,press,hoist,get,climb/appendage,appendage,finger[<android,big]'
						)
						(proc255_0 4 16)
					)
					((Said 'get>')
						(if (Said '/cog,wheel')
							(proc255_0 4 17)
						else
							(pEvent claimed: 0)
						)
					)
				)
			)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 9) (gLongSong fade:))
		(super newRoom: newRoomNumber)
	)
)

(instance bucket of Act
	(properties)
	
	(method (init)
		(super init:)
		(bucket
			view: 13
			setPri: 6
			setCel: (Random 0 1)
			setLoop: 0
			illegalBits: 0
			ignoreActors: 1
			ignoreHorizon: 1
			posn: 242 65
			setStep: -1 2
			moveSpeed: 1
			setCycle: 0
			setMotion: MoveTo 242 -3 self
			setScript: bScript
		)
	)
)

(instance bScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (bucket setPri: 6))
			(1
				(if (== (bucket cel?) 2)
					(global2 newRoom: 9)
				else
					(bucket
						setCel: (Random 0 1)
						posn: 242 107
						setMotion: MoveTo 242 -3 self
					)
					(self state: (- state 1))
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
			x: (if (== gGGGGNorth 1) 227 else 102)
			y: 128
			setPri: 9
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
					((Said '/motivator,artifact,device') (if global186 (proc255_0 4 18) else (proc255_0 4 19)))
					(
						(or
							(Said '/plug[<modular,8,spaceware]')
							(Said '/spaceware[<8]')
						)
						(proc255_0 4 20)
					)
					((Said '[<down,below,at][/dirt,deck]') (proc255_0 4 21))
				)
			)
			(
			(Said 'drag,press,remove,get/plug[<modular,8,spaceware]') (proc255_0 4 22))
			(
				(Said
					'turn,get,manipulate,press,roll,drag/motivator,artifact,device'
				)
				(proc255_0 4 23)
			)
			(
			(Said '(turn<on),begin/motivator,artifact,device') (proc255_0 4 24))
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
					setPri: 9
					setStep: 1 2
					x: (if gGGGNorth 211 else 88)
					y: -19
					illegalBits: 0
					ignoreHorizon: 1
					ignoreActors: 1
					init:
					setCycle: Fwd
					setMotion: MoveTo (if gGGGNorth 211 else 88) 112 self
				)
			)
			(1 (Timer set: self 2))
			(2
				(cond 
					((== gGGGGNorth 3)
						(= global148 4)
						(= gGGGGNorth gGGGNorth)
						(clunkTune play:)
						(gGame changeScore: -15)
						(motivator init:)
						(proc0_10)
						(= gGGNorth gGNorth)
						(proc255_0 4 25)
					)
					(
					(and (== gGGNorth gGNorth) (== gGGGGNorth gGGGNorth))
						(newAct setLoop: 2)
						(motivator hide:)
						(= gGGNorth 0)
						(clunkTune play:)
						(gGame changeScore: 15)
						(= gGGGGNorth 3)
						(= global148 5)
						(proc0_10)
						(proc255_0 4 26)
					)
					(else (proc255_0 4 27) (= global148 4))
				)
				(self changeState: 3)
			)
			(3
				(newAct
					setLoop: (if (== gGGGGNorth 3) 2 else 0)
					setMotion: MoveTo (newAct x?) -19 self
				)
			)
			(4 (global2 newRoom: 9))
		)
	)
)

(instance clunkTune of Sound
	(properties
		number 76
		priority 15
	)
)
