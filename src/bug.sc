;;; Sierra Script 1.0 - (do not remove this comment)
(script# 511)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Wander)
(use Follow)
(use Chase)
(use Avoid)
(use Sound)
(use Cycle)
(use Feature)
(use Obj)

(public
	bug 0
)

(local
	local0
	bugX
	bugY
	local3
	local4
)
(instance bug of Act
	(properties)
	
	(method (init)
		(super init:)
		(self setScript: scorp)
	)
	
	(method (delete)
		(super delete:)
		(DisposeScript 511)
	)
)

(instance zap of Sound
	(properties)
)

(instance bugBlock of Blk
	(properties)
)

(instance scorp of Script
	(properties)
	
	(method (init)
		(super init: &rest)
		(Load rsSOUND 90)
	)
	
	(method (doit)
		(super doit:)
		(if (!= gGNorth gNewRoomNumber) (return))
		(if (gCast contains: bug)
			(if
				(&
					(OnControl
						2
						(- (bug x?) 13)
						(- (bug y?) 1)
						(+ (bug x?) 13)
						(bug y?)
					)
					global591
				)
				(bug posn: bugX (+ bugY 2))
				(if local0
					(bug setAvoider: Avoid setMotion: Chase gEgo 5 self)
				else
					(bug setAvoider: 0 setMotion: Wander 200)
				)
			)
			(if
				(and
					(== global104 0)
					(== global119 0)
					(< (gEgo distanceTo: bug) 150)
				)
				(proc255_0 511 0)
				(= global119 1)
			)
			(if (!= (OnControl 1 (bug x?) (bug y?)) 0)
				(= bugX (bug x?))
				(= bugY (bug y?))
			)
			(if (or (< state 2) (== state 6))
				(cond 
					((!= global104 0) (if (== local0 1) (= local0 0) (self changeState: 6)))
					((!= local0 1)
						(= state 1)
						(bug
							setAvoider: 0
							setAvoider: Avoid
							setMotion: Chase gEgo 5 self
						)
						(= local0 1)
					)
				)
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(bug
					view: 71
					posn: (Random 1 300) (Random 160 180)
					illegalBits: -2
					ignoreControl: 4
					setStep: 3 2
					setLoop: -1
					setCycle: Walk
					setAvoider: Avoid
					setMotion: Chase gEgo 5 self
				)
				(switch gGNorth
					(42
						(= local4 0)
						(bug ignoreControl: 8192 4096)
					)
					(44
						(= local4 0)
						(bug ignoreControl: 8192)
					)
					(45 (= local4 82))
					(46
						(= local4 80)
						(bug ignoreControl: 2048)
					)
					(47
						(= local4 105)
						(bug ignoreControl: 16)
					)
					(48 (= local4 86))
					(50
						(= local4 55)
						(bug ignoreControl: 8)
					)
					(51
						(= local4 87)
						(bug ignoreControl: 8)
					)
					(52 (= local4 97))
				)
				(bugBlock top: 0 bottom: local4 right: 319 left: 0)
				(bug observeBlocks: bugBlock)
				(if (and (not global119) (== global104 0))
					(proc255_0 511 0)
					(= global119 1)
				)
				(self changeState: 1)
				(= local0 1)
			)
			(2
				(if (!= gGNorth gNewRoomNumber) (return))
				(if (!= global104 0)
					(= local0 0)
					(self changeState: 6)
					(return)
				)
				(proc0_2)
				(gEgo setMotion: 0)
				(if (< (bug x?) (gEgo x?))
					(bug setLoop: 6 cel: 255)
				else
					(bug setLoop: 7 cel: 255)
				)
				(bug
					setCycle: End self
					setAvoider: 0
					setAvoider: Avoid
					setMotion: Follow gEgo 1
				)
			)
			(3
				(if (!= global104 0)
					(= local0 0)
					(self changeState: 6)
					(return)
				)
				(proc0_2)
				(gEgo setMotion: 0)
				(zap number: 90 priority: 10 play:)
				(bug
					setMotion: 0
					setPri: 14
					setLoop: 8
					setAvoider: 0
					cel: 0
				)
				(= cycles 3)
			)
			(4
				(if (!= global104 0)
					(= local0 0)
					(self changeState: 6)
					(return)
				)
				(gEgo view: 16 setLoop: 0 cel: (& (gEgo loop?) $0001))
				(bug
					setPri: -1
					setLoop: -1
					setCycle: Walk
					setAvoider: 0
					setMotion: Wander 200
				)
				(proc0_10)
				(proc255_0 511 1)
				(= seconds 5)
			)
			(5 (proc0_17 901 0 12 17))
			(6
				(bug
					setLoop: -1
					setCycle: Walk
					setAvoider: 0
					setMotion: Wander 200
				)
				(= local0 0)
			)
		)
	)
)
