#include <stdio.h>

int main(){

	int l,w,h,min,min2,prm1,prm2,prm3,sum=0,wrap=0,bow,area=0,ribbon=0,side1,side2,side3;

	FILE *fp = fopen("order.txt","r");

	while((fscanf(fp,"%dx%dx%d",&l,&w,&h))!=EOF){

		side1 = 2*l*h;
		side2 = 2*w*h;
		side3 = 2*l*w;
		min = side1;
		if(min>side2) min = side2;
		if(min>side3) min = side3;
		min /= 2;
	
		area = side1+side2+side3+min;
		wrap += area;
	
		prm1 = 2*(l+h);
		prm2 = 2*(w+h);
		prm3 = 2*(l+w);
		min2 = prm1;
		if(min2>prm2) min2 = prm2;
		if(min2>prm3) min2 = prm3;
		
		bow = l*w*h;
	
		sum = min2+bow;
		ribbon += sum;

	}

	printf("Total area of wrapping paper\t= %d\n",wrap);
	printf("Total length of ribbon needed\t= %d\n",ribbon);

	fclose(fp);

	return 0;
}

