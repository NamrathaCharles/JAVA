package com.command;

import java.util.Scanner;

		public class Another {
			public static void main(String[] args) {
                int[][] seatingPrices = {{10,10,10,10,10,10,10,10,10,10},
										 {10,10,10,10,10,10,10,10,10,10},
										 {10,10,10,10,10,10,10,10,10,10},
										 {10,10,20,20,20,20,20,20,10,10},
										 {10,10,20,20,20,20,20,20,10,10},
										 {10,10,20,20,20,20,20,20,10,10},
										 {20,20,30,30,40,40,30,30,20,20},
										 {20,30,30,40,50,50,40,30,30,20},
										 {30,40,50,50,50,50,50,50,40,30}};

				for(int row=0; row<seatingPrices.length; row++) {
							for(int col = 0; col<seatingPrices[row].length; col++){
								System.out.print(seatingPrices[row][col] + " ");

							}
							System.out.println();
							System.out.println();
				}

				System.out.println("The seating and corresponding prices are show above. Seats with the price of $0 are not available.");


			menu(seatingPrices);


		}
		
			public static void menu(int[][]seatingPrices) {

				Scanner sc = new Scanner(System.in);
				
				int row = 0;
				int seat = 0;
				int price = 0;
				int choice;

				do {       //do while loop runs menu until user enters designated number

						System.out.print("1: Enter Desired Row and Seat Number\n2: Enter Desired Price\n3: Finish\n");
						choice = sc.nextInt();

						switch(choice) {
							case 1:
								//get user selection for row and seat number
								System.out.println("Please make your selection (the bottom left corner is row 1, seat 1). Enter the row number.\n");
								row = sc.nextInt();
								System.out.println();
								System.out.println("Enter the seat number");
								seat = sc.nextInt();

								boolean sA = seatAvailable(seatingPrices, row, seat);   //calls seatAvailable method
								if(sA == true) {
									boolean toPur = purchase(seatingPrices, row, seat); //calls purchase method
									if(toPur = true) {
										seatingPrices = changeAvailability(seatingPrices, row, seat); //calls changeAvailability method
										String purchaseTotal = totalPrice(seatingPrices, row, seat);  //calls purchaseTotal method
									}
									else {
										menu(seatingPrices);
									}

								}
								else {
									System.out.println("This seat is not available");
									menu(seatingPrices);
								}

								break;
							case 2:
								//gets user desired price
								System.out.println("Enter the desired price");
								price = sc.nextInt();

								showAvailableSeatsByPrice(seatingPrices, price);  //calls showAvailableSeatsByPrice method

								System.out.println("Enter your row and seat selections");
								row = sc.nextInt();
								seat = sc.nextInt();

								sA = seatAvailable(seatingPrices, row, seat);
								if(sA == true) {
									boolean toPur = purchase(seatingPrices, row, seat);
									if(toPur = true) {
									seatingPrices = changeAvailability(seatingPrices, row, seat);
									String purchaseTotal = totalPrice(seatingPrices, row, seat);
								}
								else {
									menu(seatingPrices);
								}
							}
							else {
								System.out.println("This seat is not available\n");
								menu(seatingPrices);
							}

								break;
							}
					}while(choice != 3);
					System.exit(0);
				}

				/*The seatAvailable method determines if a seat is available or not based on price $0=unavailable
					@param seatingPrices holds the seatingPrices array
					@param r holds the selected row number
					@param s holds the selected seat number
				*/
				public static boolean seatAvailable(int[][] seatingPrices, int r, int s) {
					//determines if seat selected by user is available

					if(seatingPrices[r][s] != 0) {
						return true;
					}
					else {
						return false;
					}
				}

				
				public static String showAvailableSeatsByPrice(int[][] seatingPrices, int p) {
					//show seats that are user-entered price
					String sASBP= " ";
					boolean status;

					System.out.println("Seats that match price:\n");
					for(int row=0; row<seatingPrices.length; row++) {    //searches array for matching prices
						for(int seat = 0; seat<seatingPrices[row].length; seat++){
							if(seatingPrices[row][seat] == p) {
								status = true;
							}
							else {
								status = false;
							}
							if(status == true) {
								sASBP = "Available seat of price: " + seatingPrices[row][seat] + " (Row and Seat respectively)";
							}
						}
					}
					return sASBP;
				}

				
				public static String totalPrice(int[][] seatingPrices, int r, int s) {
					int p = seatingPrices[r][s];
					String totalPrice = " Your purchase amount is " + p;
					return totalPrice;
				}

				
				public static int[][] changeAvailability(int[][] seatingPrices, int r, int s) {
					
					seatingPrices[r][s] = 0;
					return seatingPrices;
				}

				/*The purchase method determines if a user wants to buy the selected ticket
					@param seatingPrices holds the seatingPrices array
					@param r holds the row entered by the user
					@param s holds the seat entered by the user
					@return user's decision to buy the ticket or not
				*/
				public static boolean purchase(int[][]seatingPrices, int r, int s){
					//determines if user wants to purchase the selected seat
					Scanner sc = new Scanner(System.in);

					String purC;
					boolean stat = true;

					System.out.println("Would you like to purchase seat " + seatingPrices[s] + " in row " + seatingPrices[r] + " for $" + seatingPrices[r][s] + "?");
					System.out.println("Enter Y for yes or N for no");
					purC = sc.next();

					if(purC.equalsIgnoreCase("y")) {
						stat = true;
					}
					else if(purC.equalsIgnoreCase("n")) {
						stat = false;
					}
					return stat;
				}
			}


