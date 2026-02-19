push 0
push 5
push 10
push function0
push function1
lfp
lfp
push -3
add
lw
lfp
push -2
add
lw
lfp
stm
ltm
ltm
push -4
add
lw
js
push 0
beq label18
lfp
push 8
lfp
stm
ltm
ltm
push -5
add
lw
js
push 0
beq label18
push 1
b label19
label18:
push 0
label19:
push 1
beq label16
push 0
b label17
label16:
push 1
label17:
print
halt

function0:
cfp
lra
lfp
push 1
add
lw
lfp
push 2
add
lw
bleq label2
push 0
b label3
label2:
push 1
label3:
push 1
beq label0
push 0
b label1
label0:
lfp
push 1
add
lw
lfp
push 2
add
lw
beq label6
push 0
b label7
label6:
push 1
label7:
push 1
beq label4
push 1
b label5
label4:
push 0
label5:
label1:
stm
sra
pop
pop
pop
sfp
ltm
lra
js

function1:
cfp
lra
push 7
lfp
push -2
add
lw
lfp
push 1
add
lw
bleq label10
push 0
b label11
label10:
push 1
label11:
push 0
beq label8
lfp
push 1
add
lw
push 100
beq label14
push 0
b label15
label14:
push 1
label15:
push 0
beq label12
push 0
b label13
label12:
push 1
label13:
push 0
beq label8
push 1
b label9
label8:
push 0
label9:
stm
pop
sra
pop
pop
sfp
ltm
lra
js