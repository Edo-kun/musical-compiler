	# Authors: Vivek Sah, Alex Rinker, Ed Zhou
	# Date: May 2017
	# Compiled From Sources: testfiles/sweet_child_of_mine.bft

	.data
	.globl	gc_flag
gc_flag:
	.word	0

	.text
	li $a0 500
	li $v0 32
	syscall
	b label1
label0:
	li $a2 26
	li $a3 100
	li $a1 325
	li $a0 72
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 84
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 79
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 77
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 89
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 79
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 88
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 79
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	jr $ra
label1:
	b label3
label2:
	li $a2 26
	li $a3 100
	li $a1 325
	li $a0 74
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 84
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 79
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 77
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 89
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 79
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 88
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 79
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	jr $ra
label3:
	b label5
label4:
	li $a2 26
	li $a3 100
	li $a1 325
	li $a0 77
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 84
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 79
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 77
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 89
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 79
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 88
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 79
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	jr $ra
label5:
	li $s1 2
label6:
	beq $s1 $zero label7
	sub $s1 $s1 1
	sw $s1 -4($sp)
	jal label0
	lw $s1 -4($sp)
	b label6
label7:
	li $s1 2
label8:
	beq $s1 $zero label9
	sub $s1 $s1 1
	sw $s1 -4($sp)
	jal label2
	lw $s1 -4($sp)
	b label8
label9:
	li $s1 2
label10:
	beq $s1 $zero label11
	sub $s1 $s1 1
	sw $s1 -4($sp)
	jal label4
	lw $s1 -4($sp)
	b label10
label11:
	li $s1 2
label12:
	beq $s1 $zero label13
	sub $s1 $s1 1
	sw $s1 -4($sp)
	jal label0
	lw $s1 -4($sp)
	b label12
label13:
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 72
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 84
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 52
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 77
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 52
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 89
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 52
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 88
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 55
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 72
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 55
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 84
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 57
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 55
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 77
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 89
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 52
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 88
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 46
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 74
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 46
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 84
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 46
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 77
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 89
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 88
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 46
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 52
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 74
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 50
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 84
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 46
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 52
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 77
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 50
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 89
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 46
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 52
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 88
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 50
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 41
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 77
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 41
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 84
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 41
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 41
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 77
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 41
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 89
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 41
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 41
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 88
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 36
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 77
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 84
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 77
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 89
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 88
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 72
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 52
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 84
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 77
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 52
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 89
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 88
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 52
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 36
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 72
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 36
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 84
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 36
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 36
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 77
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 36
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 89
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 36
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 36
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 88
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 36
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 325
	li $a0 79
	li $a2 26
	li $a3 100
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	b label15
label14:
	li $a2 26
	li $a3 127
	li $a1 325
	li $a0 60
	li $v0 31
	syscall
	li $a0 36
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 72
	li $v0 31
	syscall
	li $a0 43
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 67
	li $v0 31
	syscall
	li $a0 48
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 65
	li $v0 31
	syscall
	li $a0 43
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 77
	li $v0 31
	syscall
	li $a0 72
	li $v0 31
	syscall
	li $a0 53
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 67
	li $v0 31
	syscall
	li $a0 43
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 76
	li $v0 31
	syscall
	li $a0 52
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 67
	li $v0 31
	syscall
	li $a0 43
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	jr $ra
label15:
	b label17
label16:
	li $a2 26
	li $a3 127
	li $a1 325
	li $a0 62
	li $v0 31
	syscall
	li $a0 34
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 72
	li $v0 31
	syscall
	li $a0 41
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 67
	li $v0 31
	syscall
	li $a0 46
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 65
	li $v0 31
	syscall
	li $a0 41
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 77
	li $v0 31
	syscall
	li $a0 72
	li $v0 31
	syscall
	li $a0 50
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 67
	li $v0 31
	syscall
	li $a0 41
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 76
	li $v0 31
	syscall
	li $a0 72
	li $v0 31
	syscall
	li $a0 46
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 67
	li $v0 31
	syscall
	li $a0 41
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	jr $ra
label17:
	b label19
label18:
	li $a2 26
	li $a3 127
	li $a1 325
	li $a0 65
	li $v0 31
	syscall
	li $a0 41
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 72
	li $v0 31
	syscall
	li $a0 48
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 67
	li $v0 31
	syscall
	li $a0 53
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 65
	li $v0 31
	syscall
	li $a0 48
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 77
	li $v0 31
	syscall
	li $a0 72
	li $v0 31
	syscall
	li $a0 57
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 67
	li $v0 31
	syscall
	li $a0 48
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 76
	li $v0 31
	syscall
	li $a0 72
	li $v0 31
	syscall
	li $a0 53
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 67
	li $v0 31
	syscall
	li $a0 48
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	jr $ra
label19:
	li $s1 2
label20:
	beq $s1 $zero label21
	sub $s1 $s1 1
	sw $s1 -4($sp)
	jal label14
	lw $s1 -4($sp)
	b label20
label21:
	li $s1 2
label22:
	beq $s1 $zero label23
	sub $s1 $s1 1
	sw $s1 -4($sp)
	jal label16
	lw $s1 -4($sp)
	b label22
label23:
	li $s1 2
label24:
	beq $s1 $zero label25
	sub $s1 $s1 1
	sw $s1 -4($sp)
	jal label18
	lw $s1 -4($sp)
	b label24
label25:
	li $s1 2
label26:
	beq $s1 $zero label27
	sub $s1 $s1 1
	sw $s1 -4($sp)
	jal label14
	lw $s1 -4($sp)
	b label26
label27:
	b label29
label28:
	li $a2 26
	li $a3 127
	li $a1 325
	li $a0 36
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 43
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 48
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 50
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 52
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 53
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 55
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a0 57
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	jr $ra
label29:
	li $a1 325
	li $a0 36
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 650
	li $a0 72
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 74
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 67
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 43
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 650
	li $a0 72
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 67
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 50
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 52
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 650
	li $a0 74
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 67
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 55
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 650
	li $a0 76
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 57
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 36
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 650
	li $a0 67
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 72
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 77
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 43
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 48
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 650
	li $a0 67
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 76
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 50
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 52
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 650
	li $a0 74
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 53
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 55
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a1 650
	li $a0 72
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
	li $a1 325
	li $a0 57
	li $a2 26
	li $a3 127
	li $v0 31
	syscall
	li $a0 275
	li $v0 32
	syscall
