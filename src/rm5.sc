;;; Sierra Script 1.0 - (do not remove this comment)
(script# 5)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Timer)
(use Cycle)
(use Game)
(use Feature)
(use Obj)

(public
	rm5 0
)

(local
	newAct
)
(instance rm5 of Rm
	(properties
		picture 5
		style $0000
		horizon 10
		west 2
	)
	
	(method (init &tmp [temp0 50])
		(if (!= gNorth 9) (self setLocales: 700))
		(SL enable:)
		(if (== gNorth 9) (proc0_2))
		(if (== gGGNorth gGNorth)
			(Load rsVIEW 36)
			(motivator init:)
		)
		(if (== gNorth 9)
			(Load rsSOUND 76)
			(Load rsVIEW 258)
		else
			(Load rsVIEW 0)
			(gEgo init:)
		)
		(super init:)
		(self setScript: rmScript)
	)
	
	(method (doit)
		(if
		(and (gEgo inRect: 152 138 292 148) (>= (gEgo x?) 289))
			(global2 newRoom: 6)
		)
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
	
	(method (handleEvent pEvent &tmp [temp0 50])
		(if (pEvent claimed?) (return))
		(switch (pEvent type?)
			(evSAID
				(cond 
					((Said 'look>')
						(cond 
							(
								(or
									(Said '<in,in,through/craft,stage[<eva]')
									(Said '[<in,in,through,at]/pit,tube')
								)
								(proc255_0 5 0)
							)
							((Said '[<at]/craft,stage') (proc255_0 5 1))
							(
								(or
									(Said '[<at]/bone,android,protrusion[<metallic]')
									(Said
										'[<at]/appendage,head[<bone,android,protrusion[<metallic]]'
									)
								)
								(proc255_0 5 2)
							)
							(
							(Said '/mog,finger,head,appendage[<android,man]') (proc255_0 5 3))
							((Said '[<around,at,in][/area,!*]') (proc255_0 5 4))
						)
					)
					((Said 'converse/man,mog,android') (proc255_0 5 5))
					((Said 'climb,crawl/craft,stage') (proc255_0 5 6))
					((Said 'crawl/console') (proc255_0 5 7))
					((Said 'get/toaster') (proc255_0 5 8))
					(
						(Said
							'get,explore,climb[<on,onto,up]/bone,android,protrusion[<metallic]'
						)
						(proc255_0 5 9)
					)
				)
			)
			(evMOUSEBUTTON
				(if
					(and
						(not (pEvent claimed?))
						(gEgo inRect: 0 137 310 145)
						(> (pEvent x?) 174)
						(< (pEvent y?) 149)
					)
					(gEgo setMotion: MoveTo (pEvent x?) (gEgo y?))
					(pEvent claimed: 1)
				)
			)
		)
	)
)

(instance rmScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond 
					(global157 (gEgo setMotion: MoveTo 292 144))
					((== gNorth 9) (motivator setScript: grabScript))
					((== gNorth 6) (gEgo setStep: -1 2 posn: 288 142 init:))
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
			x: (if (== gGGGGNorth 1) 147 else 46)
			y: 127 species 9
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
					((Said '/motivator,artifact,device') (if global186 (proc255_0 5 10) else (proc255_0 5 11)))
					(
						(or
							(Said '/plug[<modular,8,spaceware]')
							(Said '/spaceware[<8]')
						)
						(proc255_0 5 12)
					)
					((Said '[<down,below,at][/dirt,deck]') (proc255_0 5 13))
				)
			)
			(
				(Said
					'turn,get,manipulate,press,roll,drag/motivator,artifact,device'
				)
				(proc255_0 5 14)
			)
			(
			(Said '(turn<on),begin/motivator,artifact,device') (proc255_0 5 15))
			(
			(Said 'press,drag,remove,get/plug[<modular,8,spaceware]') (proc255_0 5 16))
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
					setPri: 9
					setStep: 1 2
					x: (if gGGGNorth 134 else 30)
					y: -19
					illegalBits: 0
					ignoreHorizon: 1
					ignoreActors: 1
					init:
					setCycle: Fwd
					setMotion: MoveTo (if gGGGNorth 134 else 30) 110 self
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
						(proc255_0 5 17)
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
						(proc255_0 5 18)
					)
					(else (proc255_0 5 19) (= global148 4))
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
