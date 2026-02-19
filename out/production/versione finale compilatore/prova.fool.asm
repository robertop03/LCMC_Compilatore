push 0
lhp
push function0
lhp
sw
lhp
push 1
add
shp
push function1
lhp
sw
lhp
push 1
add
shp
push function2
lhp
sw
lhp
push 1
add
shp
lhp
push function3
lhp
sw
lhp
push 1
add
shp
push function4
lhp
sw
lhp
push 1
add
shp
push 10
lhp
sw
lhp
push 1
add
shp
push 10000
push -2
add
lw
lhp
sw
lhp
lhp
push 1
add
shp
push 3
push 4
lhp
sw
lhp
push 1
add
shp
lhp
sw
lhp
push 1
add
shp
push 10000
push -3
add
lw
lhp
sw
lhp
lhp
push 1
add
shp
push -1
lfp
lfp
lfp
push -5
add
lw
stm
ltm
ltm
lw
push 0
add
lw
js
lfp
push -4
add
lw
stm
ltm
ltm
lw
push 1
add
lw
js
lfp
lfp
lfp
push -4
add
lw
stm
ltm
ltm
lw
push 2
add
lw
js
lfp
push -5
add
lw
stm
ltm
ltm
lw
push 1
add
lw
js
lfp
push -6
add
lw
push -1
beq label2
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
push -7
add
lw
lfp
push -8
add
lw
add
label1:
print
halt

function0:
cfp
lra
lfp
lw
push -1
add
lw
push 1
add
stm
sra
pop
sfp
ltm
lra
js

function1:
cfp
lra
lfp
lw
push -1
add
lw
lfp
push 1
add
lw
add
stm
sra
pop
pop
sfp
ltm
lra
js

function2:
cfp
lra
lfp
lw
push -1
add
lw
stm
sra
pop
sfp
ltm
lra
js

function3:
cfp
lra
lfp
lw
push -1
add
lw
lfp
lw
push -2
add
lw
add
stm
sra
pop
sfp
ltm
lra
js

function4:
cfp
lra
lfp
lw
push -1
add
lw
lfp
lw
push -2
add
lw
add
lfp
push 1
add
lw
mult
stm
sra
pop
pop
sfp
ltm
lra
js