using PrimeMinisters;
using System.Collections.Generic;
using System.IO;

namespace Lab102
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }






        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {








            this.Piclabel = new System.Windows.Forms.Label();
            this.picPhoto = new System.Windows.Forms.PictureBox();
            this.lblName = new System.Windows.Forms.Label();
            this.lblTerm = new System.Windows.Forms.Label();
            this.lvlParty = new System.Windows.Forms.Label();
            this.lstPrimeMinisters = new System.Windows.Forms.ListBox();
            ((System.ComponentModel.ISupportInitialize)(this.picPhoto)).BeginInit();
            this.SuspendLayout();
            // 
            // Piclabel
            // 
            this.Piclabel.AutoSize = true;
            this.Piclabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Piclabel.Location = new System.Drawing.Point(62, 26);
            this.Piclabel.Name = "Piclabel";
            this.Piclabel.Size = new System.Drawing.Size(140, 37);
            this.Piclabel.TabIndex = 0;
            this.Piclabel.Text = "Pictures";
            this.Piclabel.Click += new System.EventHandler(this.label1_Click);
            // 
            // picPhoto
            // 
            this.picPhoto.Location = new System.Drawing.Point(55, 79);
            this.picPhoto.Name = "picPhoto";
            this.picPhoto.Size = new System.Drawing.Size(306, 252);
            this.picPhoto.TabIndex = 1;
            this.picPhoto.TabStop = false;
            // 
            // lblName
            // 
            this.lblName.AutoSize = true;
            this.lblName.Font = new System.Drawing.Font("Microsoft Sans Serif", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblName.Location = new System.Drawing.Point(48, 343);
            this.lblName.Name = "lblName";
            this.lblName.Size = new System.Drawing.Size(175, 37);
            this.lblName.TabIndex = 2;
            this.lblName.Text = "Jeff Bezos";
            // 
            // lblTerm
            // 
            this.lblTerm.AutoSize = true;
            this.lblTerm.Location = new System.Drawing.Point(55, 400);
            this.lblTerm.Name = "lblTerm";
            this.lblTerm.Size = new System.Drawing.Size(37, 13);
            this.lblTerm.TabIndex = 3;
            this.lblTerm.Text = "Term: ";
            // 
            // lvlParty
            // 
            this.lvlParty.AutoSize = true;
            this.lvlParty.Location = new System.Drawing.Point(55, 434);
            this.lvlParty.Name = "lvlParty";
            this.lvlParty.Size = new System.Drawing.Size(37, 13);
            this.lvlParty.TabIndex = 4;
            this.lvlParty.Text = "Party: ";
            // 
            // lstPrimeMinisters
            // 
            this.lstPrimeMinisters.FormattingEnabled = true;
            this.lstPrimeMinisters.Location = new System.Drawing.Point(479, 79);
            this.lstPrimeMinisters.Name = "lstPrimeMinisters";
            this.lstPrimeMinisters.Size = new System.Drawing.Size(185, 251);
            this.lstPrimeMinisters.TabIndex = 5;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.LightSkyBlue;
            this.ClientSize = new System.Drawing.Size(737, 497);
            this.Controls.Add(this.lstPrimeMinisters);
            this.Controls.Add(this.lvlParty);
            this.Controls.Add(this.lblTerm);
            this.Controls.Add(this.lblName);
            this.Controls.Add(this.picPhoto);
            this.Controls.Add(this.Piclabel);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.picPhoto)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();



          






        }

        #endregion

        private System.Windows.Forms.Label Piclabel;
        private System.Windows.Forms.PictureBox picPhoto;
        private System.Windows.Forms.Label lblName;
        private System.Windows.Forms.Label lblTerm;
        private System.Windows.Forms.Label lvlParty;
        private System.Windows.Forms.ListBox lstPrimeMinisters;
    }
}

