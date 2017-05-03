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
	li $a2 76
	li $a3 127
	li $a1 500
	li $a0 72
	li $v0 31
	syscall
	li $a0 400
	li $v0 32
	syscall
	li $a0 84
	li $v0 31
	syscall
	li $a0 400
	li $v0 32
	syscall
	li $a0 79
	li $v0 31
	syscall
	li $a0 400
	li $v0 32
	syscall
	li $a0 77
	li $v0 31
	syscall
	li $a0 400
	li $v0 32
	syscall
	li $a0 89
	li $v0 31
	syscall
	li $a0 400
	li $v0 32
	syscall
	li $a0 79
	li $v0 31
	syscall
	li $a0 400
	li $v0 32
	syscall
	li $a0 88
	li $v0 31
	syscall
	li $a0 400
	li $v0 32
	syscall
	li $a0 79
	li $v0 31
	syscall
	li $a0 400
	li $v0 32
	syscall
	jr $ra
label1:
	li $s1 5
label2:
	beq $s1 $zero label3
	sub $s1 $s1 1
	sw $s1 -4($sp)
	jal label0
	lw $s1 -4($sp)
	b label2
label3:
