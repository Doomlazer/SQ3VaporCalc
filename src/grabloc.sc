;;; Sierra Script 1.0 - (do not remove this comment)
(script# 703)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Game)

(public
	grabloc 0
)

(instance grabloc of Locale
	(properties)
	
	(method (handleEvent pEvent)
		(super handleEvent: pEvent)
		(if
		(or (!= (pEvent type?) evSAID) (pEvent claimed?))
			(return)
		)
		(cond 
			(
				(and
					(> global132 3)
					(or
						(Said 'look/grabber,control,device')
						(Said 'look/button<claw,grabber,device')
					)
				)
				(proc255_0 703 0)
			)
			((Said 'expectorate') (proc255_0 703 1))
			((Said 'ass/hosebag') (proc255_0 703 2))
			((Said 'kiss') (proc255_0 703 3))
			((Said 'use/cable')
				(if (gEgo has: 1)
					(proc255_0 703 4)
				else
					(proc255_0 703 5)
				)
			)
			((Said 'tie') (proc255_0 703 6))
			((Said 'holler,whistle,laugh[<out]') (proc255_0 703 7))
			((Said 'listen') (proc255_0 703 8))
			((Said 'cry[<out]') (proc255_0 703 9))
			((Said 'clean') (proc255_0 703 10))
			((Said 'write') (proc255_0 703 11))
			((Said 'climb[<up,down]/banister,beam[<iron]') (proc255_0 703 12))
			((Said 'use,climb,stand,erect,lean/ladder') (if (gEgo has: 2) (proc255_0 703 13) else (proc0_9)))
			((Said 'beat') (proc255_0 703 14))
			((Said 'hang<from/banister,beam[<iron]') (proc255_0 703 15))
			((Said 'climb<down[/*]') (proc255_0 703 16))
			((Said 'look>')
				(cond 
					(
						(or
							(Said '[<down,below,at]/dirt,deck')
							(Said '<down,below,at[/dirt,deck]')
						)
						(proc255_0 703 17)
					)
					((Said '/appendage,head,leg,body,self') (proc255_0 703 18))
					((Said '/iron,scrap,debris,heap,garbage,ass') (proc255_0 703 19))
					((Said '/conduit') (proc255_0 703 20))
					(
						(or
							(Said '[<up,above,at]/ceiling')
							(Said '<up,above,at[/ceiling]')
						)
						(proc255_0 703 21)
					)
					((Said '/claw[<grabber]')
						(if (or (== global132 4) (== global132 5))
							(proc255_0 703 22)
						else
							(pEvent claimed: 0)
						)
					)
					((Said '/motivator')
						(if (== gGGGGNorth 3)
							(cond 
								((or (== global132 4) (== global132 5)) (proc255_0 703 22))
								((== gGNorth 13) (proc255_0 703 23))
								(else (proc255_0 703 24))
							)
						else
							(proc255_0 703 24)
						)
					)
					((Said '/partition,console[<w,north,pod,w]') (proc255_0 703 25))
					((Said '/banister,banister,beam[<iron]')
						(if (< global132 4)
							(proc255_0 703 26)
						else
							(proc255_0 703 27)
						)
					)
					((Said '/lamp') (proc255_0 703 28))
					((Said '/grate') (proc255_0 703 29))
				)
			)
			((Said 'drop,hold[<in]/crystal/mouth') (proc255_0 703 30))
			((Said 'eat,break/crystal[<glowing]') (proc255_0 703 31))
			(
				(Said
					'sit,crawl,(get<off)[<down,on]/banister,banister,beam,conduit,bar'
				)
				(proc255_0 703 32)
			)
			((Said 'use,get/motivator<motivator')
				(if (== gGGGGNorth 3)
					(proc255_0 703 33)
				else
					(proc255_0 703 34)
				)
			)
			((Said 'nap,(lie<down)[/deck]') (proc255_0 703 35))
			((or (== global132 4) (== global132 5))
				(cond 
					((Said 'look/chair[<grabber,device]') (proc255_0 703 36))
					((Said '(stand[<up]),(get<up,out,off)') (proc255_0 703 37))
					((Said 'look/button[<claw]') (proc255_0 703 38))
					((Said 'get[<up]/motivator')
						(if (== gGGGGNorth 3)
							(proc255_0 703 39)
						else
							(proc255_0 703 40)
						)
					)
					((Said 'look/control,console[<device,grabber]') (proc255_0 703 41))
					(
						(or
							(Said
								'drag,press,use,manipulate,go[<forward,backward,back][/stick,throttle,control,knob]'
							)
							(Said
								'begin,manipulate,drive[<forward,backward,back]/grabber,device'
							)
						)
						(proc255_0 703 42)
					)
					((Said 'release[/throttle,stick,control]') (proc255_0 703 43))
					((Said 'look/claw[<grabber,device]') (proc255_0 703 22))
					((Said 'climb') (proc255_0 703 44))
					(
						(or
							(Said 'get,climb[<onto,on,to]/banister,beam')
							(Said 'get<up,on/banister,beam')
						)
						(proc255_0 703 45)
					)
					(
					(Said 'get,jump,leap,climb[<onto,on,to]/conduit,bar') (proc255_0 703 46))
					(
						(Said
							'stand,climb,get[<up,onto,off,down,on,out]/grabber,device,claw,banister,beam'
						)
						(proc255_0 703 47)
					)
					((Said 'open/grate') (proc255_0 703 48))
					((Said 'jump/craft') (proc255_0 703 49))
					((Said 'jump[<down,up]') (proc255_0 703 50))
				)
			)
		)
	)
)
