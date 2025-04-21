import requests
import time
import argparse
import threading


#Coop
#A



#B








#Pie
# Create a function that does not require an argument and does the following:
# Start timer.
# In a threaded fashion, call the function in Part A with appropriate arguments.
# [see wk03_d2_threading.py.]
# If your system complains about replacing the files in Part 2, you will need to remove/delete the files before running this part
# End timer when all the threads have completed their downloads.
# Print elapse times.

# Third is to write a function to download the same set of images using threads.
# You will measure the time taken for both downloads to decide if there is any advantage of using threads.

#C
def download_image(url):
    #remove querty parameters just in case
    url_parts = url.split("?")
    #get url
    response = requests.get(url, allow_redirects=True)
    #Get file name and set all to jpg, if not already
    filename = url_parts[0].split("/")[-1]
    if not filename.endswith('.jpg'):
        filename += '.jpg'
    # Write content to file
    with open(filename, 'wb') as file:
        file.write(response.content)
    return filename


def questionC():
    urls = [
        'https://th.bing.com/th/id/OIP.z-dkECmUFma29zYrb27JkwAAAA?w=264&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.MhwSzfXnBG1MpuuA6IFi-AAAAA?w=218&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.m8b7Y9-81Q4UMCBMaFkw2QAAAA?w=198&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.XN9D7tH47WNJ8h214YgqTwAAAA?w=220&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.cFvfW8dARmuVtR3zOxfTSAHaE9?w=274&h=183&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.wcEy7Ow-TaAohBCz6USqCAAAAA?w=265&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.9FWt0sWpi4UOee5o3WdI-QHaFj?w=224&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.JYXSCIpGskpiOxYTw1vuwgAAAA?w=252&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.QjWOHkojgYSz1LhaypSB-gAAAA?w=190&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.Wlfm_lF4VWlYLiPNfbmbDwHaHa?w=181&h=181&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.ZquJ_NwCCyWfvpAEeU-vngAAAA?w=142&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.C6q29lesR7-Ork5YKuI6LwAAAA?w=257&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.A7o1Bm-XNr9A_4pLPCCujgAAAA?w=252&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.oSjt2rY3YUScDY7pw3b1WAHaFj?w=236&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.AroTG9KnmisPIhICyGjoDAHaFj?w=223&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.zSyHBN9_rn_O9XBkdPx-agAAAA?w=189&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.pGTxkbwreLj7l2ORZrtA8gAAAA?w=147&h=184&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.5SaLUh616MU7KDIP2_0VCwAAAA?w=204&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.S-lrZd2TFhSEpI3VRQyKqQAAAA?w=173&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.sDmZWxXBrF329vZvDu2HrAAAAA?w=266&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.5umgRLykyWn-v_5HmOS0NAHaE7?w=243&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.MPayRq2bYdhfVUj5O9BCnwAAAA?w=125&h=184&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.OeLv1q1dEfGkl1bRHfM5awHaFj?w=240&h=180&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.MksSZEmu5Cgly2HNvRp4NQAAAA?w=180&h=163&c=7&r=0&o=5&pid=1.7',
        'https://th.bing.com/th/id/OIP.HCpPn-IRV8SVidBlRoBRUwHaE7?w=287&h=191&c=7&r=0&o=5&pid=1.7'
    ]

    start_time = time.time()

    threads = []
    for url in urls:
        thread = threading.Thread(target=download_image, args=(url,))
        threads.append(thread)
        thread.start()

    for thread in threads:
        thread.join()

    end_time = time.time()
    elapsed_time = end_time - start_time
    print("Elapsed time with threads:", elapsed_time)



questionC()




#D