clear variables;
close all;
clc;

%% Question 2.1.1 %%

m3 = 10;
sigma3 = 2;
N1 = 1000;
B = 100;
Fs = 1000;
t = (0:1:N1-1)/Fs;
n = 10000;
N2 = randn(1, n);
M = 20;
hold on;
[x1, x2, x3, Az, Bz] = synthese(N1, B, m3, sigma3);
[H,f] = freqz(Bz,Az,Fs);


m1 = 0;
sigma1 = 1;
m2 = mean(x2);
sigma2 = std(x2);

[ddp1,c1,h1,x_out1] = histo(x1,m1,sigma1);
[ddp2,c2,h2,x_out2] = histo(x2,m2,sigma2);
[ddp3,c3,h3,x_out3] = histo(x3,m3,sigma3);

subplot(241);
plot(t, x1);
title('Signal blanc');

subplot(242);
plot(t, x2);
title('Signal blanc filtre');

subplot(243);
plot(t,x3);
title('Signal blanc filtre decentre sur 10');

subplot(244);
plot(f,abs(H));
title('Module du gain complexe du filtre passe bas');

subplot(245);
bar(x_out1,h1);
hold on;
plot(x_out1,h1);
plot(x_out1,ddp1,'r','Linewidth',0.5);
title('Histogramme, ddp théorique et empirique du signal blanc');

subplot(246);
bar(x_out2, h2);
hold on;
plot(x_out2,h2);
plot(x_out2,ddp2);
title('Du signal filtre');

subplot(247);
bar(x_out3, h3);
hold on;
plot(x_out3,h3);
plot(x_out3,ddp3);
title('Du signal decentre');







