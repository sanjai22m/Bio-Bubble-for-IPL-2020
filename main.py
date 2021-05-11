import mysql.connector
import sys

mydb = mysql.connector.connect(
    host="localhost",
    user="root",
    password="Iajnasnod22",
    database="biobubble"
)

mycursor = mydb.cursor()

def start():
    print("\n--------------- BIO BUBBLE MANAGEMENT SYSTEM ---------------")
    sel = input("press n for new user or e for existing user:")
    if sel == 'n':
        op = int(input("Who are you? \n1) Player \n2) Official \nenter the number:"))
        if op == 1:
            pid = input("enter your pid:")
            name = input("enter your name:")
            nationality = input("enter your nationality:")
            tplay = input("enter your type of play:")
            result = input("enter your COVID test result (+/-):")
            val = (pid, name, nationality, tplay, result)
            mycursor.execute("insert into players values(%s,%s,%s,%s,%s)", val)
            mydb.commit()
            tup = (pid,)
            mycursor.execute("insert into person_id values(%s)", tup)
            mydb.commit()
            if result == '+':
                val1 = (pid, "14 days", "*", "*", "*")
                mycursor.execute("insert into quarantine values(%s,%s,%s,%s,%s)", val1)
                mydb.commit()
                print("you are requested to be in quarantine for 14 days")
                result1 = input("enter your COVID test result 1 during quarantine:")
                result2 = input("enter your COVID test result 2 during quarantine:")
                result3 = input("enter your COVID test result 3 during quarantine:")
                restup = (result1, result2, result3, pid)
                mycursor.execute("update quarantine set result1=%s,result2=%s,result3=%s where p_id=%s", restup)
                mydb.commit()
                if result1 == '-' and result2 == '-' and result3 == '-':
                    print("you are permitted to enter the bio bubble now")
                    mycursor.execute("delete from quarantine where p_id=%s", tup)
                    mydb.commit()
                    teamname = input("enter your team name:")
                    venue = "NA"
                    val2 = (pid, teamname, venue)
                    mycursor.execute("insert into team values(%s,%s,%s)", val2)
                    mydb.commit()
                else:
                    print("you are requested to be in quarantine for 14 days")
            elif result == '-':
                teamname = input("enter your team name:")
                val2 = (pid, teamname)
                mycursor.execute("insert into team values(%s,%s)", val2)
                mydb.commit()
                print("you are permitted to enter the bubble")
            else:
                print("enter either + or -")
            mydb.commit()
            s = input("press h to return homescreen")
            if s == 'h':
                start()
            else:
                sys.exit("applicaation closed")

        elif op == 2:
            pid = input("enter your pid:")
            name = input("enter your name:")
            nationality = input("enter your nationality:")
            role = input("enter your role type:")
            result = input("enter your COVID test result (+/-):")
            val = (pid, name, nationality, role, result)
            mycursor.execute("insert into officials values(%s,%s,%s,%s,%s)", val)
            mydb.commit()
            tup = (pid,)
            mycursor.execute("insert into person_id values(%s)", tup)
            mydb.commit()
            if result == '+':
                val1 = (pid, "14 days", "*", "*", "*")
                mycursor.execute("insert into quarantine values(%s,%s,%s,%s,%s)", val1)
                mydb.commit()
                print("you are requested to be in quarantine for 14 days")
                result1 = input("enter your COVID test result 1 during quarantine:")
                result2 = input("enter your COVID test result 2 during quarantine:")
                result3 = input("enter your COVID test result 3 during quarantine:")
                restup = (result1, result2, result3, pid)
                mycursor.execute("update quarantine set result1=%s,result2=%s,result3=%s where p_id=%s", restup)
                mydb.commit()
                if result1 == '-' and result2 == '-' and result3 == '-':
                    print("you are permitted to enter the bio bubble now")
                    mycursor.execute("delete from quarantine where p_id=%s", tup)
                    mydb.commit()
                    teamname = input("enter your team name:")
                    venue = "NA"
                    val2 = (pid, teamname, venue)
                    mycursor.execute("insert into team values(%s,%s,%s)", val2)
                    mydb.commit()
                else:
                    print("you are requested to be in quarantine for 14 days")
            elif result == '-':
                teamname = input("enter your team name:")
                val2 = (pid, teamname)
                mycursor.execute("insert into team values(%s,%s)", val2)
                mydb.commit()
            else:
                print("enter either + or -")
            mydb.commit()
            s = input("press h to return homescreen")
            if s == 'h':
                start()
            else:
                sys.exit("applicaation closed")

        else:
            print("enter a valid number!")
        s = input("press h to return homescreen")
        if s == 'h':
            start()
        else:
            sys.exit("applicaation closed")

    elif sel == 'e':
        op = str(input("enter your pid:"))
        tup = (op,)
        mycursor.execute("select p_id from person_id")
        if tup in tuple(mycursor.fetchall()):
            print("1) View info \n2) Update info \n3) View all players \n4) Delete info")
            op1 = int(input("enter any option:"))
            if op1 == 1:
                mycursor.execute("select * from players where p_id=%s", tup)
                for x in mycursor.fetchall():
                    print('person id: ', x[0])
                    print('name: ', x[1])
                    print('nationality: ', x[2])
                    print('type of play: ', x[3])
                    print('initial covid result: ', x[4])
                mycursor.execute("select t.teamname,tv.venue from team t join team_venue tv on t.teamname=tv.teamname and t.p_id=%s", tup)
                for x in mycursor.fetchall():
                    print('team name: ', x[0])
                    print('venue: ', x[1])
                s = input("press h to return homescreen")
                if s == 'h':
                    start()
                else:
                    sys.exit("applicaation closed")

            elif op1 == 2:
                name = input("enter your name:")
                nationality = input("enter your nationality:")
                tplay = input("enter your type of play:")
                val = (name, nationality, tplay, op)
                mycursor.execute("update players set name=%s,nationality=%s,type_of_play=%s where p_id=%s ", val)
                mydb.commit()
                print("successfully updated info")
                s = input("press h to return homescreen")
                if s == 'h':
                    start()
                else:
                    sys.exit("applicaation closed")

            elif op1 == 3:
                print("name: nationality: team name: ")
                mycursor.execute("select p.name,p.nationality,t.teamname from players p join team t on p.p_id=t.p_id")
                for x in mycursor.fetchall():
                    print(x)
                s = input("press h to return homescreen")
                if s == 'h':
                    start()
                else:
                    sys.exit("applicaation closed")

            elif op1 == 4:
                mycursor.execute("delete from players where p_id=%s", tup)
                mydb.commit()
                mycursor.execute("delete from officials where p_id=%s", tup)
                mydb.commit()
                mycursor.execute("delete from quarantine where p_id=%s", tup)
                mydb.commit()
                mycursor.execute("delete from team where p_id=%s", tup)
                mydb.commit()
                mycursor.execute("delete from person_id where p_id=%s", tup)
                mydb.commit()
                print("your record is deleted")
                s = input("press h to return homescreen")
                if s == 'h':
                    start()
                else:
                    sys.exit("applicaation closed")
        else:
            print("your record does not exist")
            s = input("press h to return homescreen")
            if s == 'h':
                start()
            else:
                sys.exit("applicaation closed")

    else:
        print("enter valid button")
        s = input("press h to return homescreen")
        if s == 'h':
            start()
        else:
            sys.exit("application closed")

start()
